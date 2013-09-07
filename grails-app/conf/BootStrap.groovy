import org.blusky.filesafe.Requestmap

class BootStrap {

    def init = { servletContext ->
	    new Requestmap(url: '/timeline', configAttribute: 'ROLE_USER').save()
	    new Requestmap(url: '/person/*', configAttribute: 'IS_AUTHENTICATED_REMEMBERED').save()
	    new Requestmap(url: '/post/followAjax', configAttribute: 'ROLE_USER').save()
	    new Requestmap(url: '/post/addPostAjax', configAttribute: 'ROLE_USER,IS_AUTHENTICATED_FULLY').save()
	    new Requestmap(url: '/**', configAttribute: 'IS_AUTHENTICATED_ANONYMOUSLY').save()
    }

    def destroy = {
    }
}
