# p35 - Session Management (Django)

## Project Info
- Project: `pro`
- App: `app`
- Topic: Session Management (Visit Tracker + Preferred Theme + Auth)

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
cd C:\Users\annjo\Desktop\rajagiri\lab\MCA_Lab_Sem2\Django\record\from12\p35
.\env\Scripts\Activate.ps1
pip install django
python manage.py makemigrations
python manage.py migrate
python manage.py seed_data
python manage.py runserver
```

## Create Users
```powershell
python manage.py shell -c "from django.contrib.auth.models import User; User.objects.filter(username='admin').exists() or User.objects.create_superuser('admin', 'admin@example.com', 'Admin@12345'); User.objects.filter(username='user1').exists() or User.objects.create_user('user1', password='User@12345'); User.objects.filter(username='user2').exists() or User.objects.create_user('user2', password='User@12345')"
```

## URLs
- Home: `http://127.0.0.1:8000/`
- Login: `http://127.0.0.1:8000/login/`
- Logout: `http://127.0.0.1:8000/logout/`
- Admin: `http://127.0.0.1:8000/admin/`

## How to Test Sessions
1. Open `/` and refresh to see visit count increase.
2. Set a name using the set-name form.
3. Set preferred theme (light or dark).
4. Click clear session to reset data.
5. Login and logout to test auth session.

## Notes
- Templates are in `app/templates/app/`.
- SQLite is used by default (`db.sqlite3`).
