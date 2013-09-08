import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils
import uk.co.desirableobjects.oauth.scribe.OauthService

class LogoutController {
	def oauthService
	/**
	 * Index action. Redirects to the Spring security logout uri.
	 */
	def index = {
		session.removeAttribute(oauthService.findSessionKeyForRequestToken('dropbox'))
		redirect uri: SpringSecurityUtils.securityConfig.logout.filterProcessesUrl // '/j_spring_security_logout'
	}
}
