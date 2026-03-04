const form = document.getElementById("suggestionForm");
const statusEl = document.getElementById("status");
const suggestionsEl = document.getElementById("suggestions");

function showStatus(type, text) {
  statusEl.className = type; // "ok" or "err"
  statusEl.textContent = text;
}

function renderList(items) {
  if (!items.length) {
    suggestionsEl.innerHTML = "<small>No suggestions yet.</small>";
    return;
  }

  suggestionsEl.innerHTML = items.map(i => `
    <div class="item">
      <b>#${i.id} ${i.name}</b> <small>(${i.email})</small>
      <div>${escapeHtml(i.message)}</div>
    </div>
  `).join("");
}

// Basic HTML escaping for safe display
function escapeHtml(str) {
  return str
    .replaceAll("&", "&amp;")
    .replaceAll("<", "&lt;")
    .replaceAll(">", "&gt;")
    .replaceAll('"', "&quot;")
    .replaceAll("'", "&#039;");
}

async function loadSuggestions() {
  const res = await fetch("/api/suggestions");
  const data = await res.json();
  if (data.ok) renderList(data.items);
}

form.addEventListener("submit", async (e) => {
  e.preventDefault();
  showStatus("", "");

  const payload = {
    name: document.getElementById("name").value.trim(),
    email: document.getElementById("email").value.trim(),
    message: document.getElementById("message").value.trim(),
  };

  try {
    const res = await fetch("/api/suggestions", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(payload)
    });

    const data = await res.json();

    if (!res.ok || !data.ok) {
      showStatus("err", data.error || "Something went wrong.");
      return;
    }

    showStatus("ok", data.msg);
    form.reset();
    await loadSuggestions();
  } catch (err) {
    showStatus("err", "Network error. Try again.");
  }
});

// Load existing suggestions when page opens
loadSuggestions();