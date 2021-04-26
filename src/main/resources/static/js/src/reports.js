const div = document.getElementById('orders');

function getReport(link)
{
    div.innerHTML = "";
    fetch(link)
        .then((resp) => resp.json())
        .then(function(data) {
            let orders = data;
            return orders.map(function(order) {
                let divOrder = createNode('div');
                divOrder.innerHTML = `${order.id} ${order.delivery_status}`;
                divOrder.classList.add("order");
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