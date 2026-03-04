# Online Feedback System (p33)

A simple Django project for collecting and viewing user feedback.

## Setup Steps (Windows PowerShell)

1. **Activate Virtual Environment**:
   ```powershell
   cd p33
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

4. **Seed Database** (Creates staff users and feedback):
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
- **Test Staff Users** (Can view feedback list):
  - Username: `user1`, Password: `user123`
  - Username: `user2`, Password: `user123`

## URLs to Visit

- **Feedback Form**: [http://127.0.0.1:8000/feedback/](http://127.0.0.1:8000/feedback/)
- **Feedback List**: [http://127.0.0.1:8000/feedback/list/](http://127.0.0.1:8000/feedback/list/) (Requires Login)
- **Admin Panel**: [http://127.0.0.1:8000/admin/](http://127.0.0.1:8000/admin/)

## Notes
- Feedback submission is public.
- Viewing the list of feedback requires staff/admin login.
- Manual validation ensures ratings are 1-5 and messages are at least 10 characters long.
