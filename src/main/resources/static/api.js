function addOrder()
{
    console.log(document.getElementById("dstatus").value);

    const url = 'http://localhost:8080/api/order';
    const data = { delivery_status: document.getElementById("dstatus").value, id: document.getElementById("oid").value };

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
            alert(JSON.stringify(json));
        });

    const div = document.getElementById('orders');
    div.innerHTML = "";
    fetch("api/orders")
        .then((resp) => resp.json())
        .then(function(data) {
            let orders = data;
            return orders.map(function(order) {
                let divOrder = createNode('div');
                divOrder.innerHTML = `${order.id} ${order.delivery_status}`;
                divOrder.classList.add("article");
                append(div, divOrder);
            })
        })
}

function createNode(element)
{
    return document.createElement(element);
}

function append(parent, el)
{
    return parent.appendChild(el);
}
