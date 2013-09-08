package org.bluesky.filesafe

import grails.plugins.springsecurity.Secured
import org.codehaus.jackson.map.ObjectMapper
import org.scribe.model.Response
import org.scribe.model.Token

class OauthDropBoxController {
	def oauthService

	@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
	def index() {
		String sessionKey = oauthService.findSessionKeyForAccessToken('dropbox')
		Token dropboxToken = session[sessionKey]
		log.debug("dropbox token:" + dropboxToken);

		if(dropboxToken == null) {
			flash.message = "Dropbox login failed. Please try again later."
			redirect([controller: 'login', action: 'auth'])
			return
		}

		Response accountInfo = oauthService.getDropboxResource(dropboxToken, 'https://api.dropbox.com/1/account/info')
		def info
		if(accountInfo.isSuccessful())  {
			ObjectMapper mapper = new ObjectMapper()
			List<Object> array = mapper.readValue(accountInfo.body, List.class)
			info = array.getAt(0)
		}

		render ( view: 'home', model: info)
	}

	def fail() {
		flash.message = "Dropbox login failed. Please try again later."
		redirect([controller: 'login', action: 'auth'])
	}



}
