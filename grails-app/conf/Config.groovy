import   org.scribe.builder.api.DropBoxApi

// locations to search for config files that get merged into the main config;
// config files can be ConfigSlurper scripts, Java properties files, or classes
// in the classpath in ConfigSlurper format

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if (System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }

grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination
grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format
grails.mime.use.accept.header = false
grails.mime.types = [
		all: '*/*',
		atom: 'application/atom+xml',
		css: 'text/css',
		csv: 'text/csv',
		form: 'application/x-www-form-urlencoded',
		html: ['text/html', 'application/xhtml+xml'],
		js: 'text/javascript',
		json: ['application/json', 'text/json'],
		multipartForm: 'multipart/form-data',
		rss: 'application/rss+xml',
		text: 'text/plain',
		xml: ['text/xml', 'application/xml']
]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// What URL patterns should be processed by the resources plugin
grails.resources.adhoc.patterns = ['/images/*', '/css/*', '/js/*', '/plugins/*']

// The default codec used to encode data with ${}
grails.views.default.codec = "html" // none, html, base64
grails.views.gsp.encoding = "UTF-8"
grails.converters.encoding = "UTF-8"
// enable Sitemesh preprocessing of GSP pages
grails.views.gsp.sitemesh.preprocess = true
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart = false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// configure auto-caching of queries by default (if false you can cache individual queries with 'cache: true')
grails.hibernate.cache.queries = false

oauth {
	providers {
		dropbox {
			api = org.scribe.builder.api.DropBoxApi
			key = 'qcsvslsyjefbv7t'
			secret = 'oyrh4ip7uqfxgba'
			successUri = "${grailsApplication.config.grails.serverURL}/"
			failureUri = "${grailsApplication.config.grails.serverURL}/"
		//	callback = "${grailsApplication.config.grails.serverURL}/oauth/dropbox/callback"
		}
	}
	debug = true
}

environments {
	development {
		grails.serverURL = "http://cowboy274.myiomegacloud.com:8080"
		grails.app.context = "/"
		grails.logging.jul.usebridge = true
	}
	production {
		grails.serverURL = "http://cowboy274.myiomegacloud.com:8080"
		grails.app.context = "/"
		grails.logging.jul.usebridge = false
		// TODO: grails.serverURL = "http://www.changeme.com"
	}
}

// log4j configuration
log4j = {
	// Example of changing the log pattern for the default console appender:
	//
	//appenders {
	//    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
	//}

	error 'org.codehaus.groovy.grails.web.servlet',        // controllers
			'org.codehaus.groovy.grails.web.pages',          // GSP
			'org.codehaus.groovy.grails.web.sitemesh',       // layouts
			'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
			'org.codehaus.groovy.grails.web.mapping',        // URL mapping
			'org.codehaus.groovy.grails.commons',            // core / classloading
			'org.codehaus.groovy.grails.plugins',            // plugins
			'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
			'org.springframework',
			'org.hibernate',
			'net.sf.ehcache.hibernate'
}

// Added by the Spring Security Core plugin:
/*
grails.plugins.springsecurity.userLookup.userDomainClassName = 'org.blusky.filesafe.User'
grails.plugins.springsecurity.userLookup.authorityJoinClassName = 'org.blusky.filesafe.UserRole'
grails.plugins.springsecurity.authority.className = 'org.blusky.filesafe.Role'
grails.plugins.springsecurity.requestMap.className = 'org.blusky.filesafe.Requestmap'
grails.plugins.springsecurity.securityConfigType = 'Requestmap'
*/

grails {
	plugins {
		springsecurity {
			userLookup {
				userDomainClassName = 'org.blusky.filesafe.User'
				authorityJoinClassName = 'org.blusky.filesafe.UserRole'
			}
			authority.className = 'org.blusky.filesafe.Role'
			requestMap.className = 'org.blusky.filesafe.Requestmap'
			securityConfigType = 'Requestmap'

			//useSessionFixationPrevention = true

			//rejectifNoRule = true

			//auth.forceHttps = true
		}
	}
}
