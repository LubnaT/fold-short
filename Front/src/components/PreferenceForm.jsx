import React from 'react';

function PreferenceForm({ preferences, onChange, onSubmit, isLoading }) {
  return (
    <section className="card-surface form-section">
      <div className="section-heading">
        <div>
          <p className="section-label">Preferences</p>
          <h2>Tell Us What Matters</h2>
        </div>
      </div>

      <form className="preference-form" onSubmit={onSubmit}>
        <label className="form-field">
          <span>Max Budget</span>
          <input
            type="number"
            name="maxBudget"
            placeholder="e.g. 1200000"
            value={preferences.maxBudget}
            onChange={onChange}
            min="0"
          />
        </label>

        <label className="form-field">
          <span>Fuel Type</span>
          <select name="fuelType" value={preferences.fuelType} onChange={onChange}>
            <option value="Any">Any</option>
            <option value="Petrol">Petrol</option>
            <option value="Diesel">Diesel</option>
            <option value="EV">EV</option>
            <option value="CNG">CNG</option>
          </select>
        </label>

        <label className="form-field">
          <span>Body Type</span>
          <select name="bodyType" value={preferences.bodyType} onChange={onChange}>
            <option value="Any">Any</option>
            <option value="Hatchback">Hatchback</option>
            <option value="Sedan">Sedan</option>
            <option value="SUV">SUV</option>
          </select>
        </label>

        <label className="form-field">
          <span>Priority</span>
          <select name="priority" value={preferences.priority} onChange={onChange}>
            <option value="safety">Safety</option>
            <option value="mileage">Mileage</option>
            <option value="value">Value</option>
          </select>
        </label>

        <button className="primary-button" type="submit" disabled={isLoading}>
          {isLoading ? 'Loading...' : 'Get Recommendations'}
        </button>
      </form>
    </section>
  );
}

export default PreferenceForm;
