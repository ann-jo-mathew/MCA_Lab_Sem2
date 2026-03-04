/***********************
  LocalStorage Keys
************************/
const KEYS = {
  USERS: "users",
  PRODUCTS: "products",
  CART: "cart",
  SESSION: "session"
};

/***********************
  Helpers
************************/
function readLS(key, fallback) {
  const raw = localStorage.getItem(key);
  return raw ? JSON.parse(raw) : fallback;
}
function writeLS(key, value) {
  localStorage.setItem(key, JSON.stringify(value));
}
function uid(prefix = "id") {
  return prefix + "_" + Date.now() + "_" + Math.floor(Math.random() * 10000);
}

/***********************
  Seed Data (Admin + Products)
************************/
function seedDataOnce() {
  const users = readLS(KEYS.USERS, []);
  const products = readLS(KEYS.PRODUCTS, []);

  // Seed Admin if missing
  const adminExists = users.some(u => u.role === "admin");
  if (!adminExists) {
    users.push({
      id: uid("user"),
      name: "Admin",
      email: "admin@demo.com",
      password: "Admin@123", // simple demo
      role: "admin"
    });
    writeLS(KEYS.USERS, users);
  }

  // Seed Products if empty
  if (products.length === 0) {
    const sample = [
      { id: uid("p"), name: "Notebook", price: 120, image: "https://picsum.photos/seed/note/400/250", desc: "Simple notebook." },
      { id: uid("p"), name: "Backpack", price: 850, image: "https://picsum.photos/seed/bag/400/250", desc: "College backpack." },
      { id: uid("p"), name: "Water Bottle", price: 260, image: "https://picsum.photos/seed/bottle/400/250", desc: "Reusable bottle." }
    ];
    writeLS(KEYS.PRODUCTS, sample);
  }

  // Seed Cart if missing
  const cart = readLS(KEYS.CART, null);
  if (!cart) writeLS(KEYS.CART, []);
}

/***********************
  Session / Auth
************************/
function getSession() {
  return readLS(KEYS.SESSION, null);
}
function setSession(user) {
  writeLS(KEYS.SESSION, { id: user.id, role: user.role, name: user.name, email: user.email });
}
function logout() {
  localStorage.removeItem(KEYS.SESSION);
  window.location.href = "home.html";
}
function requireLogin() {
  const s = getSession();
  if (!s) window.location.href = "login.html";
  return s;
}
function requireAdmin() {
  const s = requireLogin();
  if (s.role !== "admin") window.location.href = "products.html";
  return s;
}

/***********************
  Users CRUD
************************/
function getUsers() {
  return readLS(KEYS.USERS, []);
}
function addUser({ name, email, password, role }) {
  const users = getUsers();
  const exists = users.some(u => u.email.toLowerCase() === email.toLowerCase());
  if (exists) return { ok: false, msg: "Email already registered." };

  users.push({ id: uid("user"), name, email, password, role });
  writeLS(KEYS.USERS, users);
  return { ok: true };
}
function loginUser(email, password, role) {
  const users = getUsers();
  const u = users.find(x =>
    x.email.toLowerCase() === email.toLowerCase() &&
    x.password === password &&
    x.role === role
  );
  if (!u) return { ok: false, msg: "Invalid credentials or role." };
  setSession(u);
  return { ok: true, user: u };
}

/***********************
  Products CRUD
************************/
function getProducts() {
  return readLS(KEYS.PRODUCTS, []);
}
function getProductById(id) {
  return getProducts().find(p => p.id === id);
}
function addProduct(p) {
  const products = getProducts();
  products.push({ ...p, id: uid("p") });
  writeLS(KEYS.PRODUCTS, products);
}
function updateProduct(id, updated) {
  const products = getProducts().map(p => (p.id === id ? { ...p, ...updated } : p));
  writeLS(KEYS.PRODUCTS, products);
}
function deleteProduct(id) {
  const products = getProducts().filter(p => p.id !== id);
  writeLS(KEYS.PRODUCTS, products);
}

/***********************
  Cart CRUD
************************/
function getCart() {
  return readLS(KEYS.CART, []);
}
function saveCart(cart) {
  writeLS(KEYS.CART, cart);
}
function addToCart(productId) {
  const cart = getCart();
  const item = cart.find(i => i.productId === productId);
  if (item) item.qty += 1;
  else cart.push({ id: uid("c"), productId, qty: 1 });
  saveCart(cart);
}
function updateCartQty(cartItemId, qty) {
  const cart = getCart().map(i => (i.id === cartItemId ? { ...i, qty } : i));
  saveCart(cart.filter(i => i.qty > 0));
}
function removeFromCart(cartItemId) {
  const cart = getCart().filter(i => i.id !== cartItemId);
  saveCart(cart);
}
function clearCart() {
  saveCart([]);
}

/***********************
  UI Helpers
************************/
function setNavbarUserInfo() {
  const s = getSession();
  const el = document.getElementById("navUser");
  const btn = document.getElementById("btnLogout");
  const adminLinks = document.querySelectorAll("[data-admin-only='1']");

  if (!el) return;

  if (s) {
    el.textContent = `${s.name} (${s.role})`;
    btn?.classList.remove("d-none");
    adminLinks.forEach(a => {
      if (s.role === "admin") a.classList.remove("d-none");
      else a.classList.add("d-none");
    });
  } else {
    el.textContent = "Guest";
    btn?.classList.add("d-none");
    adminLinks.forEach(a => a.classList.add("d-none"));
  }
}

function getQueryParam(key) {
  return new URLSearchParams(window.location.search).get(key);
}

/***********************
  Render Products (Products Page)
************************/
function renderProducts(targetId) {
  const wrap = document.getElementById(targetId);
  if (!wrap) return;

  const s = getSession();
  const products = getProducts();

  wrap.innerHTML = products.map(p => {
    const adminBtns = (s && s.role === "admin")
      ? `
        <div class="d-flex gap-2 mt-2">
          <md-outlined-button onclick="goEdit('${p.id}')">Edit</md-outlined-button>
          <md-outlined-button onclick="doDelete('${p.id}')">Delete</md-outlined-button>
        </div>
      `
      : "";

    return `
      <div class="col-12 col-md-6 col-lg-4">
        <md-elevated-card class="card-pad shadow-sm">
          <img src="${p.image}" alt="${p.name}" class="img-fluid rounded-3 mb-3" />
          <div class="d-flex justify-content-between align-items-center">
            <h5 class="mb-0">${p.name}</h5>
            <span class="badge bg-primary">₹${p.price}</span>
          </div>
          <p class="muted mt-2 mb-3">${p.desc}</p>
          <div class="d-flex gap-2">
            <md-filled-button onclick="buyNow('${p.id}')">Add to Cart</md-filled-button>
            <md-outlined-button onclick="viewCart()">Cart</md-outlined-button>
          </div>
          ${adminBtns}
        </md-elevated-card>
      </div>
    `;
  }).join("");
}

// Used by buttons in rendered HTML
function buyNow(productId) {
  addToCart(productId);
  alert("Added to cart!");
}
function viewCart() {
  window.location.href = "cart.html";
}
function goEdit(id) {
  window.location.href = `edit-product.html?id=${encodeURIComponent(id)}`;
}
function doDelete(id) {
  if (!confirm("Delete this product?")) return;
  deleteProduct(id);
  renderProducts("productsGrid");
}

/***********************
  Render Cart
************************/
function renderCart(targetId) {
  const wrap = document.getElementById(targetId);
  if (!wrap) return;

  const cart = getCart();
  const products = getProducts();

  if (cart.length === 0) {
    wrap.innerHTML = `<md-elevated-card class="card-pad">Cart is empty.</md-elevated-card>`;
    document.getElementById("cartTotal").textContent = "₹0";
    return;
  }

  let total = 0;

  wrap.innerHTML = cart.map(item => {
    const p = products.find(x => x.id === item.productId);
    if (!p) return "";
    const line = p.price * item.qty;
    total += line;

    return `
      <md-elevated-card class="card-pad mb-3">
        <div class="row g-3 align-items-center">
          <div class="col-12 col-md-3">
            <img src="${p.image}" class="img-fluid rounded-3" alt="${p.name}">
          </div>
          <div class="col-12 col-md-5">
            <h6 class="mb-1">${p.name}</h6>
            <div class="muted">₹${p.price} each</div>
            <div class="fw-semibold mt-1">Line Total: ₹${line}</div>
          </div>
          <div class="col-12 col-md-4">
            <div class="d-flex gap-2 align-items-center">
              <button class="btn btn-outline-secondary" onclick="cartMinus('${item.id}', ${item.qty})">-</button>
              <span class="fw-semibold">${item.qty}</span>
              <button class="btn btn-outline-secondary" onclick="cartPlus('${item.id}', ${item.qty})">+</button>
              <button class="btn btn-outline-danger ms-auto" onclick="cartRemove('${item.id}')">Remove</button>
            </div>
          </div>
        </div>
      </md-elevated-card>
    `;
  }).join("");

  document.getElementById("cartTotal").textContent = "₹" + total;
}

function cartMinus(cartItemId, qty) {
  updateCartQty(cartItemId, qty - 1);
  renderCart("cartList");
}
function cartPlus(cartItemId, qty) {
  updateCartQty(cartItemId, qty + 1);
  renderCart("cartList");
}
function cartRemove(cartItemId) {
  removeFromCart(cartItemId);
  renderCart("cartList");
}

/***********************
  Run seed on every page load
************************/
seedDataOnce();