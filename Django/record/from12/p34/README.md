# Blog Application (p34)

A multi-user Django blog application where users can create, edit, and delete their own posts.

## Setup Steps (Windows PowerShell)

1. **Activate Virtual Environment**:
   ```powershell
   cd p34
   .\env\Scripts\Activate.ps1
   ```

2. **Install Django**:
   ```powershell
   pip install django
   ```

3. **Run Migrations**:
   ```powershell
   python manage.py migrate
   ```

4. **Seed Database** (Creates users and 5 blog posts):
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

- **Post List**: [http://127.0.0.1:8000/](http://127.0.0.1:8000/)
- **Admin Panel**: [http://127.0.0.1:8000/admin/](http://127.0.0.1:8000/admin/)

## Notes
- Anyone can read the blog posts.
- Login is required to create a post.
- Only the original author (or an admin/staff) can edit or delete a post.
- Ownership checks are handled manually in the views.
