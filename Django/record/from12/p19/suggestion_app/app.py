from flask import Flask, render_template, request, jsonify

app = Flask(__name__)

# In-memory storage (for demo). Resets when server restarts.
SUGGESTIONS = []

@app.get("/")
def home():
    return render_template("index.html")

@app.post("/api/suggestions")
def save_suggestion():
    # Accept JSON from AJAX
    data = request.get_json(silent=True) or {}

    name = (data.get("name") or "").strip()
    email = (data.get("email") or "").strip()
    message = (data.get("message") or "").strip()

    # Basic validation
    if not name:
        return jsonify({"ok": False, "error": "Name is required."}), 400
    if not email or "@" not in email:
        return jsonify({"ok": False, "error": "Valid email is required."}), 400
    if not message or len(message) < 5:
        return jsonify({"ok": False, "error": "Suggestion must be at least 5 characters."}), 400

    # "Create" operation (store)
    item = {
        "id": len(SUGGESTIONS) + 1,
        "name": name,
        "email": email,
        "message": message
    }
    SUGGESTIONS.append(item)

    return jsonify({"ok": True, "msg": "Suggestion submitted successfully!", "item": item}), 201

@app.get("/api/suggestions")
def list_suggestions():
    # "Read" operation (optional)
    return jsonify({"ok": True, "items": SUGGESTIONS})

if __name__ == "__main__":
    app.run(debug=True)