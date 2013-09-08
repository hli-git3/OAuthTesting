package org.bluesky.filesafe

import grails.plugins.springsecurity.Secured
import org.codehaus.jackson.map.ObjectMapper
import org.codehaus.jackson.type.TypeReference
import org.scribe.model.Response
import org.scribe.model.Token

class OauthDropBoxController {
	def oauthService

	@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
	def index() {
		String sessionKey = oauthService.findSessionKeyForAccessToken('dropbox')
		Token dropboxToken = session[sessionKey]
		log.debug("dropbox token:" + dropboxToken);

		if (dropboxToken == null) {
			flash.message = "Dropbox login failed. Please try again later."
			redirect([controller: 'login', action: 'auth'])
			return
		}

		Response accountInfo = oauthService.getDropboxResource(dropboxToken, 'https://api.dropbox.com/1/account/info')
		def Map<String, Object> info
		if (accountInfo.isSuccessful()) {
			ObjectMapper mapper = new ObjectMapper()
			info = mapper.readValue(accountInfo.body,
					new TypeReference<Map<String, Object>>() {
						/*@Override
						int compareTo(TypeReference o) {
							return 0  //To change body of implemented methods use File | Settings | File Templates.
						}*/
					});

		}

		render(view: 'home', model: [info:info])
	}

	def fail() {
		flash.message = g.message(code: 'oouath.fail.info', args:['Dropbox'])
		redirect([controller: 'login', action: 'auth'])
	}


}
