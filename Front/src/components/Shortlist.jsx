import React from 'react';

function Shortlist({ shortlist, isLoading, error }) {
  return (
    <section className="card-surface shortlist-section">
      <div className="section-heading">
        <div>
          <p className="section-label">Shortlist</p>
          <h2>Compare Saved Cars</h2>
        </div>
      </div>

      {error && <p className="status-message error">{error}</p>}

      {isLoading ? (
        <div className="state-box">
          <p>Loading your shortlist...</p>
        </div>
      ) : shortlist.length === 0 ? (
        <div className="state-box">
          <p>Your shortlist is empty. Add cars from the recommendations above to compare them here.</p>
        </div>
      ) : (
        <>
          <div className="shortlist-grid">
            {shortlist.map((car, index) => {
              const key = car.id ?? `${car.make}-${car.model}-${car.variantName}-${index}`;
              return (
                <article className="shortlist-card" key={key}>
                  <p className="card-kicker">{car.make}</p>
                  <h3>
                    {car.model} <span>{car.variantName}</span>
                  </h3>
                  <p className="shortlist-price">Rs {Number(car.price || 0).toLocaleString()}</p>
                  <div className="shortlist-tags">
                    <span>{car.fuelType || 'N/A'}</span>
                    <span>{car.bodyType || 'N/A'}</span>
                    <span>{car.mileage || 'N/A'}</span>
                  </div>
                </article>
              );
            })}
          </div>

          <div className="compare-table-wrapper">
            <table className="compare-table">
              <thead>
                <tr>
                  <th>Criteria</th>
                  {shortlist.map((car, index) => {
                    const key = car.id ?? `${car.make}-${car.model}-${car.variantName}-${index}`;
                    return <th key={key}>{car.model}</th>;
                  })}
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>Price</td>
                  {shortlist.map((car, index) => {
                    const key = car.id ?? `price-${index}`;
                    return <td key={key}>Rs {Number(car.price || 0).toLocaleString()}</td>;
                  })}
                </tr>
                <tr>
                  <td>Fuel Type</td>
                  {shortlist.map((car, index) => {
                    const key = car.id ?? `fuel-${index}`;
                    return <td key={key}>{car.fuelType || 'N/A'}</td>;
                  })}
                </tr>
                <tr>
                  <td>Mileage</td>
                  {shortlist.map((car, index) => {
                    const key = car.id ?? `mileage-${index}`;
                    return <td key={key}>{car.mileage || 'N/A'}</td>;
                  })}
                </tr>
                <tr>
                  <td>Safety Rating</td>
                  {shortlist.map((car, index) => {
                    const key = car.id ?? `safety-${index}`;
                    return <td key={key}>{car.safetyRating || 'N/A'}</td>;
                  })}
                </tr>
                <tr>
                  <td>User Rating</td>
                  {shortlist.map((car, index) => {
                    const key = car.id ?? `user-${index}`;
                    return <td key={key}>{car.userRating || 'N/A'}</td>;
                  })}
                </tr>
              </tbody>
            </table>
          </div>
        </>
      )}
    </section>
  );
}

export default Shortlist;
