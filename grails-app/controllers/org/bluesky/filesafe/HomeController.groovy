package org.bluesky.filesafe

import grails.plugins.springsecurity.Secured

class HomeController {
	def springSecurityService

	@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    def index() {
		if (springSecurityService.isLoggedIn()) {
			render ( view: '/index')
		}
		else{
			redirect([controller: 'login', action: 'auth'])
		}
    }
}
