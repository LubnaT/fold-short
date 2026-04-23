import React from 'react';

function RecommendationCard({ car, onAddToShortlist, isShortlisted, isSubmitting }) {
  return (
    <article className="recommendation-card">
      <div className="card-top-row">
        <div>
          <p className="card-kicker">{car.make}</p>
          <h3>
            {car.model} <span>{car.variantName}</span>
          </h3>
        </div>
        <div className="price-chip">Rs {Number(car.price || 0).toLocaleString()}</div>
      </div>

      <div className="spec-grid">
        <div>
          <span className="spec-label">Fuel</span>
          <strong>{car.fuelType || 'N/A'}</strong>
        </div>
        <div>
          <span className="spec-label">Body</span>
          <strong>{car.bodyType || 'N/A'}</strong>
        </div>
        <div>
          <span className="spec-label">Mileage</span>
          <strong>{car.mileage || 'N/A'}</strong>
        </div>
        <div>
          <span className="spec-label">Safety</span>
          <strong>{car.safetyRating || 'N/A'}</strong>
        </div>
        <div>
          <span className="spec-label">User Rating</span>
          <strong>{car.userRating || 'N/A'}</strong>
        </div>
      </div>

      <div className="reason-box">
        <p className="spec-label">Why this is recommended</p>
        <p>{car.recommendationReason || 'Strong overall fit based on your selected preferences.'}</p>
      </div>

      <button
        className="secondary-button"
        type="button"
        onClick={() => onAddToShortlist(car)}
        disabled={isShortlisted || isSubmitting}
      >
        {isSubmitting ? 'Adding...' : isShortlisted ? 'Shortlisted' : 'Add to Shortlist'}
      </button>
    </article>
  );
}

export default RecommendationCard;
