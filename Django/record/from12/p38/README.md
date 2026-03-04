# p38 - Secure Authentication System (Django)

## Project Info
- Project: `pro`
- App: `app`
- Topic: Secure Authentication with Password Hashing

## Credentials
- Admin:
  - Username: `admin`
  - Password: `Admin@12345`
- Test User 1:
  - Username: `user1`
  - Password: `User@12345`
- Test User 2:
  - Username: `user2`
  - Password: `User@12345`

## Setup (Windows PowerShell)
```powershell
cd C:\Users\annjo\Desktop\rajagiri\lab\MCA_Lab_Sem2\Django\record\from12\p38
.\env\Scripts\Activate.ps1
pip install django
python manage.py makemigrations
python manage.py migrate
python manage.py seed_data
python manage.py runserver
```

## Create Admin
```powershell
python manage.py shell -c "from django.contrib.auth.models import User; User.objects.filter(username='admin').exists() or User.objects.create_superuser('admin','admin@example.com','Admin@12345')"
```

## URLs
- Register: `http://127.0.0.1:8000/register/`
- Login: `http://127.0.0.1:8000/login/`
- Dashboard: `http://127.0.0.1:8000/dashboard/`
- Logout: `http://127.0.0.1:8000/logout/`
- Admin: `http://127.0.0.1:8000/admin/`

## Password Hashing Note
- Password hashing is automatic in Django when using `User.objects.create_user()`.
- This project uses `create_user()` in both register view and seed command.

## How to Verify Passwords Are Hashed
1. Open Django admin: `/admin/`.
2. Login as admin.
3. Open a user record.
4. Password field will show as hashed/stored securely (not plain text).

## Notes
- Templates are inside `app/templates/app/`.
- SQLite is used by default.
