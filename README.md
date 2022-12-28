# Object_Oriented_Programming_Ex1


## Usage

### Download this git project:
> git clone https://github.com/moriagr/Object_Oriented_Programming_Ex1.git

### Run project
* Open the project in java editor
* Reach src -> test -> java -> Tests.java
* Run Tests.java



## Hierarchy

![image](https://user-images.githubusercontent.com/99799701/209848882-7db29a8e-9acc-4022-8241-f070a30c196b.png)

* Here Member and Sender are interfaces
* The GroupAdmin maintains a costumers list which is simply the list of currently registered observers
* The ConcreteMember has an update() method that we use to update the data of each costumer
* myNotifyAll() is called when the data is changed and the costumers (observers) need to be supplied with new data
