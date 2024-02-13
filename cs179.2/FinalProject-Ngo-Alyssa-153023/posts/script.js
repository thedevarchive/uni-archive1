//location regex from https://stackoverflow.com/a/4140339
let l = location.pathname.match(/\/posts\/(.*)/)[1];
let uid = l.slice(0, l.length - 5)

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

      ajax('https://jsonplaceholder.typicode.com/posts/')
      .then(res => {
        let body = document.querySelector('body')

        let d = document.createElement('div')

        let title = document.createElement('h1')
        title.innerText = JSON.parse(res)[uid - 1].title

        let nav = document.createElement('nav')
        nav.setAttribute('aria-label', 'breadcrumb')
        nav.setAttribute('class', 'breadcrumb')

        let ol = document.createElement('ol')
        let li1 = document.createElement('li')
        let a1 = document.createElement('a')
        a1.setAttribute('href', '../index.html')
        a1.innerText = 'Index'
        li1.appendChild(a1)
        ol.appendChild(li1)

        let aid = JSON.parse(res)[uid - 1].userId

        ajax('https://jsonplaceholder.typicode.com/users')
        .then(users => {
            user = JSON.parse(users)[aid - 1].username
            let li2 = document.createElement('li')
            let a2 = document.createElement('a')
            a2.setAttribute('href', '../users/' + aid + ".html")
            a2.innerText = user
            li2.appendChild(a2)
            ol.appendChild(li2)


        let li3 = document.createElement('li')
        let a3 = document.createElement('a')
        a3.setAttribute('href', './' + uid + '.html')
        a3.setAttribute('aria-current', 'page')
        a3.innerText = JSON.parse(res)[uid - 1].title

        li3.appendChild(a3)
        ol.appendChild(li3)
        }).catch(err => { console.log(err) })

        nav.append(ol)
        body.appendChild(nav)

        let text = document.createElement('p')
        text.innerText = JSON.parse(res)[uid - 1].body

        d.appendChild(title)
        d.appendChild(text)

        body.appendChild(d)
      })
      .catch(err => { console.log(err) })
  }
