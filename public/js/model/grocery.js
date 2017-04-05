var Grocery = class Grocery {

	constructor(id, name, allergens) {
		this.id = id;
		this.name = name;
		this.allergens = allergens;
		if(this.allergens == undefined) {
			this.allergens = [];
		}
	}

	//to convert from untyped object
	setPropsFromObject(obj) {
		this.id = obj.id;
		this.name = obj.name;
		this.allergens = obj.allergens;
	}

	removeAllergen(allergen) {
		for(var i = 0; i < this.allergens.length; i++) {
			if(this.allergens[i] == allergen) {
				this.allergens.splice(i, 1);
				break;
			}
		}
	}


	searchable() {
		return this.printableAllergens();
	}

	printableAllergens() {
		var str = "";
		for(var i = 0; i < this.allergens.length; i++) {
			if(i == 0) {
				str = str.concat(this.allergens[i]);
			}
			else {
				str = str.concat(", ").concat(this.allergens[i]);
			}
		}
		return str;
	}

}
