//location regex from https://stackoverflow.com/a/4140339
let l = location.pathname.match(/\/users\/(.*)/)[1]
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

      ajax('https://jsonplaceholder.typicode.com/posts?userId=' + uid)
      .then(post_list => {
        let body = document.querySelector('body')

        let d = document.createElement('div')

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

        let h1 = document.createElement('h1')

        ajax('https://jsonplaceholder.typicode.com/users')
        .then(res => {
            user = JSON.parse(res)[uid - 1].username
            let li2 = document.createElement('li')
            let a2 = document.createElement('a')
            a2.setAttribute('href', './' + uid + '.html')
            a2.setAttribute('aria-current', 'page')
            a2.innerText = user
            li2.appendChild(a2)
            ol.appendChild(li2)
            h1.innerText = user + '\'s posts'
        }).catch(err => { console.log(err) })

        nav.append(ol)
        body.appendChild(nav)
        body.appendChild(h1)

        post_list = JSON.parse(post_list).slice(0,10)
        post_list.forEach(post => {
            let link = '../posts/' + post.id + ".html"

          let a = document.createElement('a')
          let br = document.createElement('br')
          a.setAttribute('data-id', post.id)
            a.setAttribute('href', link)
            a.setAttribute('tabindex', "" + post.id)

          a.innerText = post.title
          d.appendChild(a)
          d.appendChild(br)
        })
        body.appendChild(d)
      })
      .catch(err => { console.log(err) })
  }

/*   .then(posts => {
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
  }) */