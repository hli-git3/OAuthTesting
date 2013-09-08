package org.bluesky.filesafe

import grails.plugins.springsecurity.Secured

class OauthDropBoxController {
	def oauthService

	@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
	def index() {
		String sessionKey = oauthService.findSessionKeyForAccessToken('dropbox')
		String dropboxToken = session[sessionKey]
		log.debug("dropbox token:" + dropboxToken);

		if(dropboxToken == null) {
			flash.message = "The token could no be retrieved... Please try again"
			redirect([controller: 'login', action: 'auth'])
			return
		}

		render ( view: 'home')

	}

	def requestToken() {

	}



}
