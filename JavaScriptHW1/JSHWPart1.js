var homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function (n) {
    if (n == 1) return 1;
    if (n == 0) return 0;
    return homework.fibonacci(n - 1) + homework.fibonacci(n - 2);
};

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function (array) {
    var i = 1;
    while(i < array.length){
        var j = i;
        while(j > 0 && array[j-1] > array[j]){
            var temp = array[j];
            array[j] = array[j-1];
            array[j-1] = temp;
            j--;
        }
        i++;
    }
    return array;
};

/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
homework.factorial = function (n) {
    var result = 1;
    while (n > 0) {
        result *= n;
        n--;
    }
    return result;
};

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function (array, n) {
    for (var i = 0; i < n; i++) {
        var temp = array[0];
        array = array.slice(1);
        array.push(temp);
    }
    return array;
};

/*
 5. Balanced Brackets

 A bracket is any one of the following: (, ), {, }, [, or ]

 The following are balanced brackets:
    ()
    ()()
    (())
    ({[]})

 The following are NOT balanced brackets:
 (
 )
 (()
 ([)]

 Return true if balanced
 Return false if not balanced
*/
homework.balancedBrackets = function (bracketsString) {
    var help = [bracketsString[0]];

    for (var i = 1; i < bracketsString.length; i++) {
        switch (bracketsString.charAt(i)) {
            case ('}'):
                if (help.pop() == '{') continue;                
                return false;
            case (']'):
                if (help.pop() == '[') continue;
                return false;
            case (')'):
                if (help.pop() == '(') continue;
                return false;
            default:
                help.push(bracketsString.charAt(i));
        }
    }
    return (help.length == 0);
};

/*

//helper variables
var f1 = homework.fibonacci;
var f2 = homework.sort;
var f3 = homework.factorial;
var f4 = homework.rotateLeft;
var f5 = homework.balancedBrackets;

//test cases
console.log("f1(0) should be 0 : " + f1(0)); 
console.log("f1(1) should be 1 : " + f1(1)); 
console.log("f1(10) should be 55 : " + f1(10));

console.log("f2() should sort array to [1,1,2,3,4,5] : " + f2([2,4,5,1,3,1]));

console.log("f3(0) should be 1 : " + f3(0)); 
console.log("f3(1) should be 1 : " + f3(1)); 
console.log("f3(3) should be 6 : " + f3(3));

console.log("f4() should flip array to [2,3,4,5,1] : " + f4([1,2,3,4,5], 1));
console.log("f4() should flip array to [2,3,4,5,1] : " + f4([1,2,3,4,5], 6));
console.log("f4() should flip array to [4,5,1,2,3] : " + f4([1,2,3,4,5], 3));

console.log("f5() should be true : " + f5("()"));
console.log("f5() should be true : " + f5("()()"));
console.log("f5() should be true : " + f5("(())"));
console.log("f5() should be true : " + f5("({[]})"));
console.log("f5() should be false : " + f5("("));
console.log("f5() should be false : " + f5(")"));
console.log("f5() should be false : " + f5("(()"));
console.log("f5() should be false : " + f5("([)]"));

*/