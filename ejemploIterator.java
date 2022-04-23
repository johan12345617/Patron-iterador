
 
// Importamos las librerias
// Aqui esta la interface que usaremos 

import java.util.Iterator;
 
// La Clase car implementa la interface iterable para poder implemnetar el iterador
 
class Car implements Iterable<String> {
  private String[] cars;
  private int index;
 
  // constructor
  public Car() {
    cars = new String[10];
    index = 0;
  }
 
  // Agregamos el metodo agregar carro
  public void addCar(String car) {
    if (index == cars.length) {
      String[] largerCars = new String[cars.length + 5];
      System.arraycopy(cars, 0, largerCars, 0, cars.length);
      cars = largerCars;
      largerCars = null;
    }
    cars[index] = car;
    index++;
  }
 
  //implementamos iterator para la clase
  @Override
  public Iterator<String> iterator() {
    Iterator<String> it = new Iterator<String>() {
 
      private int currentIndex = 0;
 
      // este metodo verifica si hay algo mas que iterar
      @Override
      public boolean hasNext() {
        return currentIndex < cars.length && cars[currentIndex] != null;
      }
 
      //este metodo seleccionara cada elemento del carro uno por uno
      //de acuerdo a su indice
      @Override
      public String next() {
        return cars[currentIndex++];
      }
 
      // remover
      @Override
      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
 
    return it;
  }
 
  // Method 6
  // Metodo principal
  public static void main(String[] args) {
 
    // Instantiating Car object
    Car cars = new Car();
 
    // Adding cars to the Array
    cars.addCar("Dodge");
    cars.addCar("Ferrari");
    cars.addCar("Sedan");
 
    // Creamos el objeto iterator
    Iterator<String> carIterator = cars.iterator();
 
    // iteramos mientras verificamos que no existe mas elementos
    while (carIterator.hasNext()) {
      System.out.println(carIterator.next());
    }
  }
}