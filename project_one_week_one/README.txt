============================================================================================

Analysis

Big O Complexity:

The complexity of my project one program majorly follows a linear time complexity,
that is, the time it takes for the algorithm to complete is proportional to the linear
growth of data. In other words, the more data that is added to the algorithm, the more
the runtime will grow.

For example:

All methods in the array use a linear sort algorithm to find a given value, or until
the algorithm reaches the end of an array. This algorithm is for(i = 0; i < x.size(); i++).
Broken down into words, this algorithm declares the variable i and sets its value to 0.
Next, as long as i !> the size of array x, it will continue to run, otherwise the algorithm
stops. Finally, to make sure the program doesn runaway, i has to increase through i++.

The methods that use this loop and for(variable x : list) are linear because they depen-
d on thesize of the array, integer, or value. If x.size() = 1, then i would only need to
iterate through the array once. However, if x.size() = 999, then i would need to iterate
through the array 999 times if id didn't find a value. This also extends the runtime of
the program.

Search students by name:

Due to the data structure of my current program, I would need to change it. Currently,
sortedStudent is sorted by a float value, or double. If you needed to find a student
based on name, it may be more efficient to change the method of sorting to alphabetical.
In addition to this, it may be more efficient to change the algoritm from linear Search
to binary search, or logarithmic time complexity.

============================================================================================