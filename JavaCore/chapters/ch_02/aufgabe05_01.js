// Dynamic typing - data type not specified
class Employee {
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }

    getDetails() {
        return `Name: ${this.name}, Age: ${this.age}`;
    }
}

let john = new Employee("John", 25);
console.log(john.getDetails());




