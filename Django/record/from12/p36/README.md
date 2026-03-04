# p36 - Pagination and Search (Django)

## Project Info
- Project: `pro`
- App: `app`
- Topic: Pagination and Search

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
cd C:\Users\annjo\Desktop\rajagiri\lab\MCA_Lab_Sem2\Django\record\from12\p36
.\env\Scripts\Activate.ps1
pip install django
python manage.py makemigrations
python manage.py migrate
python manage.py seed_data
python manage.py runserver
```

## Create Admin and Test Users
```powershell
python manage.py shell -c "from django.contrib.auth.models import User; User.objects.filter(username='admin').exists() or User.objects.create_superuser('admin','admin@example.com','Admin@12345'); User.objects.filter(username='user1').exists() or User.objects.create_user('user1', password='User@12345'); User.objects.filter(username='user2').exists() or User.objects.create_user('user2', password='User@12345')"
```

## URLs
- Students page: `http://127.0.0.1:8000/students/`
- Example search: `http://127.0.0.1:8000/students/?q=student1`
- Example pagination: `http://127.0.0.1:8000/students/?page=2`
- Example search + pagination: `http://127.0.0.1:8000/students/?q=student&page=3`
- Admin: `http://127.0.0.1:8000/admin/`

## Notes
- SQLite is used by default.
- Templates are inside `app/templates/app/`.
- Pagination is 5 students per page.
