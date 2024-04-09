from flask import Flask, request, jsonify
import joblib
import numpy as np

# Load the model
model = joblib.load('model.pkl')

# Define the Flask app
app = Flask(__name__)

# Define the predict route
@app.route('/predict', methods=['POST'])
def predict():
     # Check if request is valid JSON
    if not request.is_json:
        return jsonify({'error': 'Request must be JSON'}), 400

    # Try to extract features from the request
    try:
        data = request.get_json()
        features = data['features']
    except KeyError:
        return jsonify({'error': 'Missing "features" key in request'}), 400

    # Convert features to NumPy array
    features_array = np.array(features)

    # Predict the price
    try:
        prediction = model.predict([features_array])[0]
    except Exception as e:
        return jsonify({'error': f'Model prediction error: {str(e)}'}), 500

    # Ensure JSON serializability
    prediction_float = float(prediction)

    # Return the prediction as a JSON response
    return jsonify({'price': prediction_float})# Define the predict route
@app.route('/test', methods=['GET'])
def test():
    data =float(2)
    return jsonify({'price': data})

# Run the app
if __name__ == '__main__':
    app.run(debug=True)
