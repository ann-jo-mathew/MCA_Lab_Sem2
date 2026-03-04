import os
import django

os.environ.setdefault('DJANGO_SETTINGS_MODULE', 'pro.settings')
django.setup()

from django.contrib.auth.models import User
from app.models import Feedback

# Sample Feedback Data
feedback_data = [
    {"name": "John Doe", "email": "john@example.com", "rating": 5, "message": "Excellent service and very helpful staff!"},
    {"name": "Jane Smith", "email": "jane@example.com", "rating": 4, "message": "Pretty good, but there is room for improvement in response time."},
    {"name": "Mike Rossi", "email": "mike@example.com", "rating": 3, "message": "Average experience, nothing special but it works."},
]

def seed():
    # Create Superuser
    if not User.objects.filter(username='admin').exists():
        User.objects.create_superuser('admin', 'admin@example.com', 'admin123')
        print("Superuser created: admin / admin123")

    # Create Test Users
    test_users = [('user1', 'user123'), ('user2', 'user123')]
    for username, password in test_users:
        if not User.objects.filter(username=username).exists():
            User.objects.create_user(username=username, password=password)
            # Ensure they are staff to see the list if needed, 
            # though usually admin list is for staff
            u = User.objects.get(username=username)
            u.is_staff = True
            u.save()
            print(f"Test staff user created: {username} / {password}")

    # Create Feedback
    for data in feedback_data:
        Feedback.objects.get_or_create(**data)
    print(f"Seeded {len(feedback_data)} feedback entries.")

if __name__ == "__main__":
    seed()
