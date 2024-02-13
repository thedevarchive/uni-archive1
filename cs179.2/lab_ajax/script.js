function get(url) {
    return new Promise(function (resolve, reject) {
        let request = new XMLHttpRequest() 
        request.addEventListener('load', function() {
            if(request.status === 200) { resolve(request.responseText)
            } else {
                reject('Request was not successful')
            } 
        })
        request.open("GET", url) 
        request.send()
    })
} 

var titles = []

get('http://jsonplaceholder.typicode.com/users/')
.then(function(result){
    for(i in JSON.parse(result)) {

        let name = JSON.parse(result)[i].name
        let username = JSON.parse(result)[i].username

        get('https://jsonplaceholder.typicode.com/posts?userId=' + JSON.parse(result)[i].id)
        .then(function(res){
            titles[i] = ""
            for(j in JSON.parse(res))
            {
                titles[i] += "<li>" + JSON.parse(res)[j].title + "</li>\n"
            }
            return titles
        })
        .then(function(t){
            document.write("<div style=\"border:1px solid black;\"> <h1 style=\"margin: 10px;\">" + name + "</h1>")
            document.write("<h2 style=\"line-height: 25px; margin: 10px;\">" + username + "</h2>")
            document.write("<ul>")
            for(j in t){
                document.write(titles[i])
            }
            document.write("</ul></div>")
        })
        .catch(function (err) {
            console.error(err);
        })

        
    }
})
.catch(function (err) {
    console.error(err);
})


