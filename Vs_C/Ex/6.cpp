#include <stdio.h>
#include <string.h>


typedef void (*SoundFunc)();


struct Animal {
    SoundFunc makeSound;
};


void animalSound() {
    printf("The animal makes a sound\n");
}


void pigSound() {
    printf("The pig says: wee SS\n");
}


void dogSound() {
    printf("The dog says: wee SS\n");
}

int main() {

    struct Animal myAnimal;
    myAnimal.makeSound = animalSound;

    
    struct Animal myPig;
    myPig.makeSound = pigSound;

    
    struct Animal myDog;
    myDog.makeSound = dogSound;


    myAnimal.makeSound();
    myPig.makeSound();
    myDog.makeSound();

    return 0;
}
