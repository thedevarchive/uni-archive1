function ajax(url) {
  return new Promise(function(resolve, reject) {
    let xhr = new XMLHttpRequest()
    xhr.addEventListener('load', function(evt) {
      if(this.status === 200) {
        resolve(this.responseText)
      } else {
        reject('There was a network error')
      }
    })
    xhr.open('GET', url)
    xhr.send()
  })
}

window.onload = function() {
    ajax('https://jsonplaceholder.typicode.com/users')
    .then(res => {
        let users = JSON.parse(res).slice(0,10)
        let body = document.querySelector('body')
        users.forEach(user => {
            let d = document.createElement('div')
            d.setAttribute('data-id', user.id)
            //let username = document.createElement('h2')
            let name = document.createElement('a')
            let br = document.createElement('br')
            let link = './users/' + user.id + '.html'
            
            name.innerText = user.name + ' (' + user.username + ')'
            //username.innerText = user.username
            let textStyle = 'margin: 0;'
            name.setAttribute('style', textStyle)
            name.setAttribute('href', link)
            name.setAttribute('tabindex', "" + user.id)
            //username.setAttribute('style', textStyle)
            d.appendChild(name)
            //d.appendChild(username)
            d.appendChild(br)
            //d.setAttribute('style', 'border: solid 1px black; padding: 1em')
            body.appendChild(d)
        })
    })
    .catch(err => { console.log(err) })
}

/* window.onload = function() {
  ajax('https://jsonplaceholder.typicode.com/users')
  .then(res => {
    let users = JSON.parse(res).slice(0,10)
    let body = document.querySelector('body')
    let promises = []
    users.forEach(user => {
      promises.push(ajax('https://jsonplaceholder.typicode.com/posts?userId='+user.id))
      let d = document.createElement('div')
      d.setAttribute('data-id', user.id)
      let username = document.createElement('h2')
      let name = document.createElement('h1')
      
      name.innerText = user.name
      username.innerText = user.username
      let textStyle = 'margin: 0'
      name.setAttribute('style', textStyle)
      username.setAttribute('style', textStyle)
      d.appendChild(name)
      d.appendChild(username)
      d.setAttribute('style', 'border: solid 1px black; padding: 1em')
      body.appendChild(d)
    })
    return Promise.all(promises)
  })
  .then(posts => {
    posts.forEach(post_list => {
      post_list = JSON.parse(post_list).slice(0,10)
      let div = document.querySelector(`[data-id="${post_list[0].userId}"]`)
      let list = document.createElement('ul')
      post_list.forEach(post => {
        let li = document.createElement('li')
        li.innerText = post.title
        list.appendChild(li)
      })
      div.appendChild(list)
    })
  })
  .catch(err => { console.log(err) })
} */