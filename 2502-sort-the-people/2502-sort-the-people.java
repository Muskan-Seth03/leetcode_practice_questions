//  Object modelling apporach  
// TC: O(n log n)   sorting  the array
// SC: O(n)   allocating space for n Person objects → O(n)


class Solution {
    static class Person
    {
        String name;
        int height;
        Person(String name, int height)
        {
            this.name= name;
            this.height= height;
        }
    }

    public String[] sortPeople(String[] names, int[] heights) {
        int n= names.length;

//creates an array of Person objects with size n, but does not yet fill it with actual objects.
        Person people[] = new Person [n]; 
        for(int i=0; i< n; i++)
        {
            people[i]= new Person(names[i], heights[i]);
        } 
        // sort the people array in descending order
        Arrays.sort(people, (a, b) -> b.height - a.height); 

        String result[]= new String[n];
        for(int i=0; i<n ; i++)
        {
            result[i]= people[i].name;
        }

        return result;

    }
}

      