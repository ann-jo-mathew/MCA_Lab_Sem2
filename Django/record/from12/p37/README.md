# p37 - Form Validation and Error Handling

## Project Info
- Project: `pro`
- App: `app`
- Topic: Form Validation and Error Handling

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
cd C:\Users\annjo\Desktop\rajagiri\lab\MCA_Lab_Sem2\Django\record\from12\p37
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

## URL
- Add student form: `http://127.0.0.1:8000/student/add/`
- Admin: `http://127.0.0.1:8000/admin/`

## How to Trigger Errors
- Leave name empty.
- Enter name with less than 3 characters.
- Enter age as text like `abc`.
- Enter age outside range like `0` or `150`.
- Enter invalid email like `test`.
- Enter an already used email (for uniqueness error).

## Notes
- Uses manual POST handling in FBV (no `forms.py`).
- Field-wise errors are shown below each field.
- Save is wrapped in `try/except` to avoid crashing.
