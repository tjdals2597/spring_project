const productListBox = document.getElementById("productListBox");

function product_ajax() {
	fetch("./product?apikey=93AD5BB7C893A469D28", {
		method : "GET",
		headers : {"content-type" : "application/json; charset=UTF-8"}
	}).then(function(data) {
			return data.json();
		}).then(function(data) {
			console.log(data);
			if (data.product != 'error') {
				printProductList(data.product);
			}
			else {
				alert("오류가 발생하였습니다.\n다시 시도해주세요.");
			}
		}).catch(function() {
			alert("오류가 발생하였습니다.\n다시 시도해주세요.");
		});
}

function printProductList(plist) {
	console.log(plist);
	plist.forEach(function(data) {
		var price = '';
		if (data.discount_price == 0) {
			price = `<div class="product-price">${ data.original_price }</div>`;
		}
		else {
			price = `<div class="product-price">
              <span style="text-decoration: line-through; display: inline;">${ data.original_price }</span>
              <span style="display: inline;"> / ${ data.discount_price }</span>
            </div>`
		}
		var img = data.pimages.split("|")[1];
		productListBox.innerHTML += `
				<a href="#" class="product">
				<img src="../product_img/${ img }" width="225" height="225">
				<div class="product-name">${ data.pname }</div>
				${ price }
				</a>
		`;
	})
	productListBox.innerHTML += `<div class="clearfix"></div>`;
}

product_ajax();