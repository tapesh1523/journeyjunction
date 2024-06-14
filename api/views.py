from rest_framework import status
from rest_framework.response import Response
from rest_framework.views import APIView
from .serializers import CountrySerializer, StateSerializer, CitySerializer, PlaceSerializer, FoodPlaceSerializer, ThingSerializer
from .models import Country, State, City, Place, FoodPlace, Thing


# Create your views here.
class CountryAPIView(APIView):
  def get(self, request):
    countries = Country.objects.all()
    serializer = CountrySerializer(countries, many= True)
    return Response(serializer.data, status=status.HTTP_200_OK)
  
  def post(self, request):
    serializer = CountrySerializer(data = request.data)
    if serializer.is_valid():
      serializer.save()
      return Response(serializer.data, status=status.HTTP_200_OK)
    return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)
  
  def put(self, request, pk):
    country = self.get_object(pk)
    serializer = CountrySerializer(country, data= request.data)
    if serializer.is_valid():
      serializer.save()
      return Response(serializer.data, status=status.HTTP_200_OK)
    return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)
  
  def delete(self, request, pk):
    country = self.get_object(pk)
    country.delete()
    return Response(status=status.HTTP_204_NO_CONTENT)
  
  def get_object(self, pk):
    try:
      return Country.objects.get(pk=pk)
    except Country.DoesNotExist:
      raise Response(status=status.HTTP_404_NOT_FOUND)
    
class StateAPIView(APIView):
    def get(self, request):
        states = State.objects.all()
        serializer = StateSerializer(states, many=True)
        return Response(serializer.data, status=status.HTTP_200_OK)

    def post(self, request):
        serializer = StateSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def put(self, request, pk):
        state = self.get_object(pk)
        serializer = StateSerializer(state, data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_200_OK)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def delete(self, request, pk):
        state = self.get_object(pk)
        state.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)

    def get_object(self, pk):
        try:
            return State.objects.get(pk=pk)
        except State.DoesNotExist:
            return Response(status=status.HTTP_404_NOT_FOUND)

class CityAPIView(APIView):
    def get(self, request):
        cities = City.objects.all()
        serializer = CitySerializer(cities, many=True)
        return Response(serializer.data, status=status.HTTP_200_OK)

    def post(self, request):
        serializer = CitySerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def put(self, request, pk):
        city = self.get_object(pk)
        serializer = CitySerializer(city, data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_200_OK)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def delete(self, request, pk):
        city = self.get_object(pk)
        city.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)

    def get_object(self, pk):
        try:
            return City.objects.get(pk=pk)
        except City.DoesNotExist:
            return Response(status=status.HTTP_404_NOT_FOUND)

class PlaceAPIView(APIView):
    def get(self, request):
        places = Place.objects.all()
        serializer = PlaceSerializer(places, many=True)
        return Response(serializer.data, status=status.HTTP_200_OK)

    def post(self, request):
        serializer = PlaceSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def put(self, request, pk):
        place = self.get_object(pk)
        serializer = PlaceSerializer(place, data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_200_OK)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def delete(self, request, pk):
        place = self.get_object(pk)
        place.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)

    def get_object(self, pk):
        try:
            return Place.objects.get(pk=pk)
        except Place.DoesNotExist:
            return Response(status=status.HTTP_404_NOT_FOUND)

class FoodPlaceAPIView(APIView):
    def get(self, request):
        food_places = FoodPlace.objects.all()
        serializer = FoodPlaceSerializer(food_places, many=True)
        return Response(serializer.data, status=status.HTTP_200_OK)

    def post(self, request):
        serializer = FoodPlaceSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def put(self, request, pk):
        food_place = self.get_object(pk)
        serializer = FoodPlaceSerializer(food_place, data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_200_OK)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def delete(self, request, pk):
        food_place = self.get_object(pk)
        food_place.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)

    def get_object(self, pk):
        try:
            return FoodPlace.objects.get(pk=pk)
        except FoodPlace.DoesNotExist:
            return Response(status=status.HTTP_404_NOT_FOUND)

class ThingAPIView(APIView):
    def get(self, request):
        things = Thing.objects.all()
        serializer = ThingSerializer(things, many=True)
        return Response(serializer.data, status=status.HTTP_200_OK)

    def post(self, request):
        serializer = ThingSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def put(self, request, pk):
        thing = self.get_object(pk)
        serializer = ThingSerializer(thing, data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_200_OK)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def delete(self, request, pk):
        thing = self.get_object(pk)
        thing.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)

    def get_object(self, pk):
        try:
            return Thing.objects.get(pk=pk)
        except Thing.DoesNotExist:
            return Response(status=status.HTTP_404_NOT_FOUND)