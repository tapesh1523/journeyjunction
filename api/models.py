from django.db import models

class Country(models.Model):
    name = models.CharField(max_length=100)
    description = models.TextField()

    def __str__(self):
        return self.name
  
class State(models.Model):
    name = models.CharField(max_length=100)
    description = models.TextField()
    country = models.ForeignKey(Country, on_delete=models.CASCADE)

    def __str__(self):
        return self.name
  
class City(models.Model):
    name = models.CharField(max_length=100)
    description = models.TextField()
    state = models.ForeignKey(State, on_delete=models.CASCADE)
    crowded_month = models.CharField(max_length=100, default='Jan')
    time_to_visit = models.CharField(max_length=100, default='')
    airport = models.CharField(max_length=200, default='')
    rlwy_station = models.CharField(max_length=200, default='')
    bus_station = models.CharField(max_length=200, default='')
    duration = models.IntegerField(default=0)
    lat = models.FloatField(default=0)
    lng = models.FloatField(default=0)

    def __str__(self):
        return self.name

# Choices
class SuitableFor(models.Model):
    name = models.CharField(max_length=20, unique=True)

    def __str__(self):
        return self.name

class AttractionType(models.Model):
    name = models.CharField(max_length=20, unique=True)

    def __str__(self):
        return self.name

class Place(models.Model):
    name = models.CharField(max_length=100)
    description = models.TextField()
    city = models.ForeignKey(City, on_delete=models.CASCADE)
    attraction_type = models.ForeignKey(AttractionType, on_delete=models.CASCADE, default=1)
    duration = models.IntegerField(default=0)
    visit_fare = models.IntegerField(default=0)
    suitable_for = models.ManyToManyField(SuitableFor)
    time_to_visit = models.CharField(max_length=200, default='')
    opening_hrs = models.CharField(max_length=100, default='')
    book_process = models.CharField(max_length=100, default='')
    rating = models.FloatField(default=4)
    alert = models.CharField(max_length=400, default='')
    events = models.CharField(max_length=400, default='')
    lat = models.FloatField(default=0)
    lng = models.FloatField(default=0)

    def __str__(self):
        return self.name
  
class FoodPlace(models.Model):
    CATEGORY_CHOICES = [
        ('restaurant', 'Restaurant'),
        ('cafe', 'Cafe'),
        ('bar', 'Bar'),
        ('street_food', 'Street Food'),
    ]
    name = models.CharField(max_length=100)
    description = models.TextField()
    city = models.ForeignKey(City, on_delete=models.CASCADE)
    category = models.CharField(max_length=20, choices=CATEGORY_CHOICES)
    lat = models.FloatField(default=0)
    lng = models.FloatField(default=0)

    def __str__(self):
        return self.name

class Thing(models.Model):
    name = models.CharField(max_length=100)
    description = models.TextField()
    city = models.ForeignKey(City, on_delete=models.CASCADE)
    latitude = models.FloatField(default=0)
    longitude = models.FloatField(default=0)

    def __str__(self):
        return self.name
