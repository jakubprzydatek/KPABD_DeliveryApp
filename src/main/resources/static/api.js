const div = document.getElementById('orders');
const url = 'http://localhost:8080/api/order';
let maxId = 0;

function modifyOrder()
{
    console.log(document.getElementById("dstatus").value);

    const data = { delivery_status: document.getElementById("dstatus").value,
        id: document.getElementById("oid").value };

    fetch(
        url,
        {
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(data),
            method: "PUT"
        }
    )
        .then(data => data.json())
        .then((json) => {
            //alert(JSON.stringify(json));
        });


    getOrders();
}

function getOrders()
{
    div.innerHTML = "";
    fetch("api/orders")
        .then((resp) => resp.json())
        .then(function(data) {
            let orders = data;
            return orders.map(function(order) {
                let divOrder = createNode('div');
                divOrder.innerHTML = `${order.id} ${order.delivery_status}`;
                maxId = order.id;
                divOrder.classList.add("order");
                append(div, divOrder);
            })
        })
}

function setMaxId()
{
    fetch("api/orders")
        .then((resp) => resp.json())
        .then(function(data) {
            return data.map(function(order) {
                maxId = order.id;
            })
        })
}


function createNewOrder()
{
    setMaxId();
    console.log(maxId);

    const data = { delivery_status: 'pending', id: maxId+1 };

    fetch(
        url,
        {
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(data),
            method: "POST"
        }
    )
        .then(data => data.json())
        .then((json) => {
            //alert(JSON.stringify(json));
        });

    getOrders();
}

function createNode(element)
{
    return document.createElement(element);
}

function append(parent, el)
{
    return parent.appendChild(el);
}
