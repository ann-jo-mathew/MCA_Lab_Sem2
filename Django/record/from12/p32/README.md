# Student Management System (p32)

A simple Django project to manage student records with CRUD functionality.

## Setup Steps (Windows PowerShell)

1. **Activate Virtual Environment**:
   ```powershell
   cd p32
   .\env\Scripts\Activate.ps1
   ```

2. **Install Dependencies**:
   ```powershell
   pip install django
   ```

3. **Run Migrations**:
   ```powershell
   python manage.py migrate
   ```

4. **Seed Database** (Creates users and students):
   ```powershell
   python seed_db.py
   ```

5. **Run Server**:
   ```powershell
   python manage.py runserver
   ```

## Credentials

- **Admin User**:
  - Username: `admin`
  - Password: `admin123`
- **Test Users**:
  - Username: `user1`, Password: `user123`
  - Username: `user2`, Password: `user123`

## URLs to Visit

- **Student List**: [http://127.0.0.1:8000/](http://127.0.0.1:8000/)
- **Admin Panel**: [http://127.0.0.1:8000/admin/](http://127.0.0.1:8000/admin/)

## Notes
- All CRUD operations (Create, Update, Delete) require login.
- The project uses Function-Based Views (FBV) and manual `request.POST` handling.
