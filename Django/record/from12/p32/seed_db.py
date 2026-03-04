import os
import django

os.environ.setdefault('DJANGO_SETTINGS_MODULE', 'pro.settings')
django.setup()

from django.contrib.auth.models import User

# Sample Student Data
students_data = [
    {"name": "Alice Johnson", "age": 20, "email": "alice@example.com", "department": "Computer Science"},
    {"name": "Bob Smith", "age": 22, "email": "bob@example.com", "department": "Mathematics"},
    {"name": "Charlie Brown", "age": 21, "email": "charlie@example.com", "department": "Physics"},
    {"name": "Diana Prince", "age": 23, "email": "diana@example.com", "department": "Engineering"},
    {"name": "Ethan Hunt", "age": 19, "email": "ethan@example.com", "department": "Biology"},
]

def seed():
    from app.models import Student
    
    # Create Superuser
    if not User.objects.filter(username='admin').exists():
        User.objects.create_superuser('admin', 'admin@example.com', 'admin123')
        print("Superuser created: admin / admin123")

    # Create Test Users
    test_users = [('user1', 'user123'), ('user2', 'user123')]
    for username, password in test_users:
        if not User.objects.filter(username=username).exists():
            User.objects.create_user(username=username, password=password)
            print(f"Test user created: {username} / {password}")

    # Create Students
    for data in students_data:
        Student.objects.get_or_create(**data)
    print(f"Seeded {len(students_data)} students.")

if __name__ == "__main__":
    seed()
