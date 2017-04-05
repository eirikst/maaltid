var Meal = class meal {

	constructor(id) {
		if(id == undefined) {
			this.id = 0;
		}
		this.id = id;
		this.time = new Date();
		this.productUnits = [];
	}

	addProductUnit(productUnit) {
		this.productUnits.push(productUnit);
	}

	removeProductUnit(product) {
		for(var i = 0; i < this.productUnits.length; i++) {
			if(this.productUnits[i].product === product) {
				this.productUnits.splice(i, 1);
				break;
			}
		}
	}

	getProductUnits() {
		return productUnits;
	}
}
