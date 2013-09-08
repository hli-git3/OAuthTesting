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
			flash.message = "Dropbox login failed. Please try again later."
			redirect([controller: 'login', action: 'auth'])
			return
		}

		render ( view: 'home')
	}

	def fail() {
		flash.message = "Dropbox login failed. Please try again later."
		redirect([controller: 'login', action: 'auth'])
	}



}
