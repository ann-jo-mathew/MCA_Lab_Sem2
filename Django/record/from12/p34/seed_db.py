import os
import django

os.environ.setdefault('DJANGO_SETTINGS_MODULE', 'pro.settings')
django.setup()

from django.contrib.auth.models import User
from app.models import Post

def seed():
    # Create Superuser
    if not User.objects.filter(username='admin').exists():
        User.objects.create_superuser('admin', 'admin@example.com', 'admin123')
        print("Superuser created: admin / admin123")

    # Create Test Users
    user1, _ = User.objects.get_or_create(username='user1')
    if _: user1.set_password('user123'); user1.save(); print("Test user created: user1 / user123")
    
    user2, _ = User.objects.get_or_create(username='user2')
    if _: user2.set_password('user123'); user2.save(); print("Test user created: user2 / user123")

    # Create 5 Blog Posts
    posts_data = [
        {"title": "Getting Started with Django", "content": "Django is a high-level Python web framework that encourages rapid development and clean, pragmatic design.", "author": user1},
        {"title": "Mastering Function-Based Views", "content": "FBVs are simple, readable, and great for beginners to understand how Django handles requests.", "author": user2},
        {"title": "The Beauty of SQLite", "content": "SQLite is a C-language library that implements a small, fast, self-contained, high-reliability, full-featured, SQL database engine.", "author": user1},
        {"title": "CSS Tips for Clean UIs", "content": "Minimalist design is about removing unnecessary elements while emphasizing what matters most.", "author": user2},
        {"title": "Why I Love Python", "content": "Python is powerful, easy to learn, and has an incredible community.", "author": user1},
    ]

    for data in posts_data:
        Post.objects.get_or_create(**data)
    
    print(f"Seeded {len(posts_data)} blog posts.")

if __name__ == "__main__":
    seed()
