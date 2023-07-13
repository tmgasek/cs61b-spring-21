public class DogProblem {
    public static Dog[] largerThanFourNeighbors(Dog[] dogs) {
        Dog[] returnDogs = new Dog[dogs.length];
        int count = 0;

        for (int i = 0; i < dogs.length; i++) {
            if (isBiggestOfFour(dogs, i)) {
                returnDogs[count] = dogs[i];
                count++;
            }

        }
        returnDogs = arrayWithNoNulls(returnDogs, count);
        return returnDogs;
    }

    public static Dog[] arrayWithNoNulls(Dog[] dogs, int count) {
        Dog[] noNullDogs = new Dog[count];
        System.arraycopy(dogs, 0, noNullDogs, 0, count);
        return noNullDogs;
    }

    public static boolean isBiggestOfFour(Dog[] dogs, int i) {
        boolean isBiggest = true;

        for (int j = -2; j <= 2; j++) {
            // avoid comparing ourselves to ourselves
            if (j == 0) {
                continue;
            }
            int compareIndex = i + j;
            if (validIndex(dogs, compareIndex)) {
                if (dogs[compareIndex].weightInPounds >= dogs[i].weightInPounds) {
                    isBiggest = false;
                }
            }

        }

        return isBiggest;
    }

    public static boolean validIndex(Dog[] dogs, int i) {
        if (i < 0) {
            return false;
        }
        if (i >= dogs.length) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Dog[] dogs = new Dog[]{new Dog(10), new Dog(15), new Dog(20), new Dog(15), new Dog(10), new Dog(5), new Dog(10), new Dog(15), new Dog(22), new Dog(15), new Dog(20)};
        Dog[] bigDogs1 = largerThanFourNeighbors(dogs);

        for (Dog dog : bigDogs1) {
            System.out.print(dog.weightInPounds + " ");
        }
        System.out.println();
    }
}
