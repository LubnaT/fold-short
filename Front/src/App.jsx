import React,{ useEffect, useMemo, useState } from 'react';
import PreferenceForm from './components/PreferenceForm';
import RecommendationCard from './components/RecommendationCard';
import Shortlist from './components/Shortlist';
import { addToShortlist, getRecommendations, getShortlist } from './api/api';

const initialPreferences = {
  maxBudget: '',
  fuelType: 'Any',
  bodyType: 'Any',
  priority: 'safety',
};

function App() {
  const [preferences, setPreferences] = useState(initialPreferences);
  const [recommendations, setRecommendations] = useState([]);
  const [shortlist, setShortlist] = useState([]);
  const [loadingRecommendations, setLoadingRecommendations] = useState(false);
  const [loadingShortlist, setLoadingShortlist] = useState(true);
  const [submittingShortlistId, setSubmittingShortlistId] = useState(null);
  const [recommendationError, setRecommendationError] = useState('');
  const [shortlistError, setShortlistError] = useState('');
  const [pageMessage, setPageMessage] = useState('');

  const shortlistIds = useMemo(
    () => new Set(shortlist.map((car) => car.id ?? `${car.make}-${car.model}-${car.variantName}`)),
    [shortlist]
  );

  const loadShortlist = async () => {
    setLoadingShortlist(true);
    setShortlistError('');

    try {
      const data = await getShortlist();
      setShortlist(Array.isArray(data) ? data : []);
    } catch (error) {
      setShortlistError('We could not load your shortlist right now. Please try again.');
    } finally {
      setLoadingShortlist(false);
    }
  };

  useEffect(() => {
    loadShortlist();
  }, []);

  const handleFormChange = (event) => {
    const { name, value } = event.target;
    setPreferences((current) => ({
      ...current,
      [name]: value,
    }));
  };

  const handleGetRecommendations = async (event) => {
    event.preventDefault();
    setLoadingRecommendations(true);
    setRecommendationError('');
    setPageMessage('');

    const payload = {
      ...preferences,
      maxBudget: preferences.maxBudget ? Number(preferences.maxBudget) : null,
    };

    try {
      const data = await getRecommendations(payload);
      const results = Array.isArray(data) ? data : [];
      setRecommendations(results);

      if (results.length === 0) {
        setPageMessage('No close matches yet. Try widening your budget or using Any for fuel or body type.');
      }
    } catch (error) {
      setRecommendationError('We could not get recommendations right now. Please check the backend and try again.');
      setRecommendations([]);
    } finally {
      setLoadingRecommendations(false);
    }
  };

  const handleAddToShortlist = async (car) => {
    const carId = car.id ?? `${car.make}-${car.model}-${car.variantName}`;
    setSubmittingShortlistId(carId);
    setShortlistError('');
    setPageMessage('');

    try {
      if (typeof car.id !== 'number') {
        throw new Error('Selected car is missing a numeric id.');
      }

      const updatedIds = Array.from(
        new Set(
          [...shortlist.map((savedCar) => savedCar.id).filter((id) => typeof id === 'number'), car.id]
        )
      );

      const updatedShortlist = await addToShortlist(updatedIds);
      setShortlist(Array.isArray(updatedShortlist) ? updatedShortlist : []);
      setPageMessage(`${car.make} ${car.model} added to your shortlist.`);
    } catch (error) {
      setShortlistError('We could not add that car to your shortlist. Please try again.');
    } finally {
      setSubmittingShortlistId(null);
    }
  };

  return (
    <div className="page-shell">
      <div className="page-background" />
      <main className="app-container">
        <section className="hero-section card-surface">
          <p className="eyebrow">Car Buyer Assistant</p>
          <h1>Find Your Next Car</h1>
          <p className="hero-copy">
            Tell us your preferences and get a confident shortlist.
          </p>
        </section>

        <section className="content-grid">
          <div className="left-column">
            <PreferenceForm
              preferences={preferences}
              onChange={handleFormChange}
              onSubmit={handleGetRecommendations}
              isLoading={loadingRecommendations}
            />
          </div>

          <div className="right-column">
            <section className="card-surface results-section">
              <div className="section-heading">
                <div>
                  <p className="section-label">Recommendations</p>
                  <h2>Your Top Matches</h2>
                </div>
              </div>

              {recommendationError && <p className="status-message error">{recommendationError}</p>}
              {pageMessage && !recommendationError && <p className="status-message success">{pageMessage}</p>}

              {loadingRecommendations ? (
                <div className="state-box">
                  <p>Finding the best options for you...</p>
                </div>
              ) : recommendations.length > 0 ? (
                <div className="card-list">
                  {recommendations.map((car, index) => {
                    const carId = car.id ?? `${car.make}-${car.model}-${car.variantName}`;
                    return (
                      <RecommendationCard
                        key={carId || index}
                        car={car}
                        onAddToShortlist={handleAddToShortlist}
                        isShortlisted={shortlistIds.has(carId)}
                        isSubmitting={submittingShortlistId === carId}
                      />
                    );
                  })}
                </div>
              ) : (
                <div className="state-box">
                  <p>Start with your budget and preferences to get a shortlist.</p>
                </div>
              )}
            </section>
          </div>
        </section>

        <Shortlist shortlist={shortlist} isLoading={loadingShortlist} error={shortlistError} />
      </main>
    </div>
  );
}

export default App;
