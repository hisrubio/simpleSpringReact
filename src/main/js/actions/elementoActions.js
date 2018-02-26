

export function fetchUsers() {


    fetch('/api/v1/element/list/')
        .then((response) => {
            console.log(response.data);
            return response.data;
        })
        .then((data) => {
            console.log(data)
        })

}

export function addElemento(json) {


    var data = new FormData();
    data.append("json", JSON.stringify(json));

    console.log(json)
    fetch('/api/v1/element/create/', {
        method: "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
        body: JSON.stringify(json)
    })
        .then((response) => {
            console.log(response.data);
            return response.data;
        })
        .then((data) => {
            console.log(data)
        })

}