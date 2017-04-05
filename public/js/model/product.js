var Product = class Product {

	constructor(id, name, groceries) {
		this.id = id;
		this.name = name;
    this.groceries = groceries;//faktisk objekt
		if(this.groceries == undefined) {
			this.groceries = [];
		}
    //egentlig for view-lista, dårlig design sorry
    this.unit = "stk";
    this.quantity = 1;
	}

  //to convert from untyped object
  setPropsFromObject(obj) {
    this.id = obj.id;
    this.name = obj.name;
    this.groceries = [];

    for(var i = 0; i < obj.groceries.length; i++) {
      var grocery = new Grocery();
      grocery.setPropsFromObject(obj.groceries[i]);
      this.groceries.push(grocery);
    }
  }

	removeGrocery(grocery) {
		for(var i = 0; i < this.groceries.length; i++) {
			if(this.groceries[i] == grocery) {
				this.groceries.splice(i, 1);
				break;
			}
		}
	}

  searchable() {
    return this.printableGroceries();
  }

	printableGroceries() {
		var str = "";
		for(var i = 0; i < this.groceries.length; i++) {
			if(i == 0) {
				str = str.concat(this.groceries[i].name);
			}
			else {
				str = str.concat(", ").concat(this.groceries[i].name);
			}
		}
		return str;
	}
}
