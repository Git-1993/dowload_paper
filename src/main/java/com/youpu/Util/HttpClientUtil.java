package com.youpu.Util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONObject;
import net.sf.json.JSON;
import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class HttpClientUtil {

	private static Logger logger = LoggerFactory.getLogger("HttpClientUtil.class");

	public static JsonNode put(String url, List<NameValuePair> params) {
		URI uri = null;
		try {
			uri = new URIBuilder(url).setParameters(params).build();
		} catch (URISyntaxException e1) {
			throw new RuntimeException("URI语法异常，url=" + url);
		}
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPut httpPut = new HttpPut(uri);
		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httpPut);
			HttpEntity reponseEntity = response.getEntity();
			if (reponseEntity != null) {
				InputStream instream = reponseEntity.getContent();
				try {
					BufferedReader in = new BufferedReader(new InputStreamReader(instream, "UTF-8"));
					StringBuffer buffer = new StringBuffer();
					String line = "";
					while ((line = in.readLine()) != null) {
						buffer.append(line);
					}
					ObjectMapper mapper = new ObjectMapper();
					JsonNode root = mapper.readTree(buffer.toString());
					return root;
				} finally {
					instream.close();
				}
			}
		} catch (Exception e) {
			logger.error("PUT请求发生异常:url=" + url + ",params=" + params.toString());
			logger.error(e.getMessage());
		}
		return null;
	}

	public static JsonNode post(String url, List<NameValuePair> params) {
		URI uri = null;
		try {
			uri = new URIBuilder(url).build();
		} catch (URISyntaxException e1) {
			logger.error("URL语法异常:url=" + url + ",params=" + params.toString());
			logger.error(e1.getMessage());
		}
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(uri);
		UrlEncodedFormEntity requestEntity = new UrlEncodedFormEntity(params, Consts.UTF_8);
		httpPost.setEntity(requestEntity);
		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httpPost);
			HttpEntity reponseEntity = response.getEntity();
			if (reponseEntity != null) {
				InputStream instream = reponseEntity.getContent();
				try {
					BufferedReader in = new BufferedReader(new InputStreamReader(instream, "UTF-8"));
					StringBuffer buffer = new StringBuffer();
					String line = "";
					while ((line = in.readLine()) != null) {
						buffer.append(line);
					}
					ObjectMapper mapper = new ObjectMapper();
					JsonNode root = mapper.readTree(buffer.toString());
					return root;
				} finally {
					instream.close();
				}
			}
		} catch (Exception e) {
			logger.error("POST请求发生异常:url=" + url + ",params=" + params.toString());
			logger.error(e.getMessage());
		}
		return null;
	}
	public static String doPost(String url, List<NameValuePair> params) {
		URI uri = null;
		try {
			uri = new URIBuilder(url).build();
		} catch (URISyntaxException e1) {
			logger.error("URL语法异常:url=" + url + ",params=" + params.toString());
			logger.error(e1.getMessage());
		}
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(uri);
		UrlEncodedFormEntity requestEntity = new UrlEncodedFormEntity(params, Consts.UTF_8);
		httpPost.setEntity(requestEntity);
		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httpPost);
			HttpEntity reponseEntity = response.getEntity();
			if (reponseEntity != null) {
				InputStream instream = reponseEntity.getContent();
				try {
					BufferedReader in = new BufferedReader(new InputStreamReader(instream, "UTF-8"));
					StringBuffer buffer = new StringBuffer();
					String line = "";
					while ((line = in.readLine()) != null) {
						buffer.append(line);
					}
					return buffer.toString();
				} finally {
					instream.close();
				}
			}
		} catch (Exception e) {
			logger.error("POST请求发生异常:url=" + url + ",params=" + params.toString());
			logger.error(e.getMessage());
		}
		return null;
	}



	public static String httpPostWithJSON(String url,JSONObject jsonParam) throws Exception {

		HttpPost httpPost = new HttpPost(url);
		CloseableHttpClient client = HttpClients.createDefault();
		String respContent = null;


		StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");// 解决中文乱码问题
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");
		httpPost.setEntity(entity);
		System.out.println();

		// 表单方式
		// List<BasicNameValuePair> pairList = new
		// ArrayList<BasicNameValuePair>();
		// pairList.add(new BasicNameValuePair("name", "admin"));
		// pairList.add(new BasicNameValuePair("pass", "123456"));
		// httpPost.setEntity(new UrlEncodedFormEntity(pairList, "utf-8"));

		HttpResponse resp = client.execute(httpPost);
		if (resp.getStatusLine().getStatusCode() == 200) {
			HttpEntity he = resp.getEntity();
			respContent = EntityUtils.toString(he, "UTF-8");
		} else {
			System.out.println(resp.toString());

			System.out.println(EntityUtils.toString(resp.getEntity(), "UTF-8"));
		}
		return respContent;
	}







	public static String doPostJson(String url, JSONObject jsonObject) {
		URI uri = null;
		try {
			uri = new URIBuilder(url).build();
		} catch (URISyntaxException e1) {
			logger.error("URL语法异常:url=" + url + ",params=" + jsonObject.toString());
			logger.error(e1.getMessage());
		}
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(uri);
		CloseableHttpResponse response = null;
		try {
			httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");
			httpPost.addHeader("X-Powered-By", "ASP.NET");

			String jsonstr=jsonObject.toString();
			StringEntity se = new StringEntity(jsonstr);
			se.setContentType("text/json");
			se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
			httpPost.setEntity(se);
			response = httpclient.execute(httpPost);
			HttpEntity reponseEntity = response.getEntity();
			if (reponseEntity != null) {
				InputStream instream = reponseEntity.getContent();
				try {
					BufferedReader in = new BufferedReader(new InputStreamReader(instream, "UTF-8"));
					StringBuffer buffer = new StringBuffer();
					String line = "";
					while ((line = in.readLine()) != null) {
						buffer.append(line);
					}
					return buffer.toString();
				} finally {
					instream.close();
				}
			}
		} catch (Exception e) {
			logger.error("POST请求发生异常:url=" + url + ",params=" + jsonObject.toString());
			logger.error(e.getMessage());
		}
		return null;
	}





	public static Map getMap(String url, List<NameValuePair> params) {
		URI uri = null;
		try {
			if (params != null)
				uri = new URIBuilder(url).setParameters(params).build();
			else
				uri = new URIBuilder(url).build();
			logger.info("request uri=" + uri.toString());
		} catch (URISyntaxException e1) {
			logger.error("URL语法异常:url=" + url + ",params=" + params.toString());
			logger.error(e1.getMessage());
		}
		if (uri == null)
			return null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(uri);
		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httpGet);
			HttpEntity reponseEntity = response.getEntity();
			if (reponseEntity != null) {
				InputStream instream = reponseEntity.getContent();
				try {
					BufferedReader in = new BufferedReader(new InputStreamReader(instream, "UTF-8"));
					StringBuffer buffer = new StringBuffer();
					String line = "";
					while ((line = in.readLine()) != null) {
						buffer.append(line);
					}
					ObjectMapper mapper = new ObjectMapper();
					Map map = mapper.readValue(buffer.toString(), Map.class);
					return map;
				} finally {
					instream.close();
				}
			}
		} catch (Exception e) {
			if (params != null)
				logger.error("GET请求发生异常:url=" + url + ",params=" + params.toString());
			else
				logger.error("GET请求发生异常:url=" + url);
			logger.error(e.getMessage());
		}
		return null;
	}
	
	public static JsonNode get(String url, List<NameValuePair> params) {
		URI uri = null;
		try {
			if (params != null)
				uri = new URIBuilder(url).setParameters(params).build();
			else
				uri = new URIBuilder(url).build();
		} catch (URISyntaxException e1) {
			logger.error("URL语法异常:url=" + url + ",params=" + params.toString());
			logger.error(e1.getMessage());
		}
		if (uri == null)
			return null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(uri);
		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httpGet);
			HttpEntity reponseEntity = response.getEntity();
			if (reponseEntity != null) {
				InputStream instream = reponseEntity.getContent();
				try {
					BufferedReader in = new BufferedReader(new InputStreamReader(instream, "UTF-8"));
					StringBuffer buffer = new StringBuffer();
					String line = "";
					while ((line = in.readLine()) != null) {
						buffer.append(line);
					}
					ObjectMapper mapper = new ObjectMapper();
					JsonNode root = mapper.readTree(buffer.toString());
					return root;
				} finally {
					instream.close();
				}
			}
		} catch (Exception e) {
			if (params != null)
				logger.error("GET请求发生异常:url=" + url + ",params=" + params.toString());
			else
				logger.error("GET请求发生异常:url=" + url);
			logger.error(e.getMessage());
		}
		return null;
	}

	public static JSONObject getJSONObject(String url, List<NameValuePair> params) {
		URI uri = null;
		try {
			if (params != null)
				uri = new URIBuilder(url).setParameters(params).build();
			else
				uri = new URIBuilder(url).build();
		} catch (URISyntaxException e1) {
			logger.error("URL语法异常:url=" + url + ",params=" + params.toString());
			logger.error(e1.getMessage());
		}
		if (uri == null)
			return null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(uri);
		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httpGet);
			HttpEntity reponseEntity = response.getEntity();
			if (reponseEntity != null) {
				InputStream instream = reponseEntity.getContent();
				try {
					BufferedReader in = new BufferedReader(new InputStreamReader(instream, "UTF-8"));
					StringBuffer buffer = new StringBuffer();
					String line = "";
					while ((line = in.readLine()) != null) {
						buffer.append(line);
					}
					logger.info("http get JSONObject response data {}", buffer.toString());
					return JSONObject.fromObject(buffer.toString());
				} finally {
					instream.close();
				}
			}
		} catch (Exception e) {
			if (params != null)
				logger.error("GET请求发生异常:url=" + url + ",params=" + params.toString());
			else
				logger.error("GET请求发生异常:url=" + url);
			logger.error(e.getMessage());
		}
		return null;
	}

	public static void delete(String url) {
		URI uri = null;
		try {
			uri = new URIBuilder(url).build();
		} catch (URISyntaxException e1) {
			logger.error("URL语法异常" + url);
			logger.error(e1.getMessage());
		}
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpDelete httpDelete = new HttpDelete(uri);
		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httpDelete);
			HttpEntity reponseEntity = response.getEntity();
			if (reponseEntity != null) {
				InputStream instream = reponseEntity.getContent();
				try {
					BufferedReader in = new BufferedReader(new InputStreamReader(instream, "UTF-8"));
					StringBuffer buffer = new StringBuffer();
					String line = "";
					while ((line = in.readLine()) != null) {
						buffer.append(line);
					}
				} finally {
					instream.close();
				}
			}
		} catch (Exception e) {
			logger.error("DELETE请求发生异常:" + url);
			logger.error(e.getMessage());
		}
	}

	/**
	 * @author liuzeke
	 * @dateTime 2016-6-1 下午12:17:35
	 * @description 以Map<String,String>作为参数发送post请求 返回json
	 * @param url
	 * @param map
	 * @return
	 */
	public static JsonNode postAsJson(final String url, final Map<String, String> map) {
		try {
			return new ObjectMapper().readTree(postAsString(url, map));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @author liuzeke
	 * @dateTime 2016-6-2 上午10:39:36
	 * @description 以Map<String,String>作为参数发送post 返回String
	 * @param url
	 * @param map
	 * @return
	 */
	public static String postAsString(final String url, final Map<String, String> map) {
		try {
			return Jsoup.connect(url).timeout(10000).ignoreContentType(true).method(Method.POST).data(map).execute()
					.body();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		String url = "http://192.168.1.68:8080/detector/api/submit/login";
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("username", "ceshi2"));
		params.add(new BasicNameValuePair("password", "123456"));
		params.add(new BasicNameValuePair("v", "2.0"));
		params.add(new BasicNameValuePair("d", "1"));
		params.add(new BasicNameValuePair("c", "1"));
		params.add(new BasicNameValuePair("t", "1"));
		JsonNode jsonNode = HttpClientUtil.get(url, params);
		if (jsonNode != null) {

		}
	}

	/**
	 * 
	 * @author lvwenwen
	 * @dateTime 2016-6-1 上午11:28:32
	 * @description
	 * @param url
	 * @param params
	 * @return
	 */
	public static String doGet(String url, List<NameValuePair> params) {
		URI uri = null;
		try {
			if (params != null)
				uri = new URIBuilder(url).setParameters(params).build();
			else
				uri = new URIBuilder(url).build();
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(uri);
		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httpGet);
			HttpEntity reponseEntity = response.getEntity();
			if (reponseEntity != null) {
				InputStream instream = reponseEntity.getContent();
				try {
					BufferedReader in = new BufferedReader(new InputStreamReader(instream, "UTF-8"));
					StringBuffer buffer = new StringBuffer();
					String line = "";
					while ((line = in.readLine()) != null) {
						buffer.append(line);
					}
					return buffer.toString();
				} finally {
					instream.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @author lvwenwen
	 * @dateTime 2016-6-1 上午11:28:32
	 * @description
	 * @param url
	 * @param params
	 * @return
	 */
	public static String doPost(String url, List<NameValuePair> params, FileInputStream fis) {
		// URI uri = null;
		// try {
		// if (params != null)
		// uri = new URIBuilder(url).setParameters(params).build();
		// else
		// uri = new URIBuilder(url).build();
		// } catch (URISyntaxException e1) {
		// e1.printStackTrace();
		// }

		String boundary = "Boundary-b1ed-4060-99b9-fca7ff59c113"; // Could be
																	// any
																	// string
		String Enter = "\r\n";
		StringBuffer str = new StringBuffer();
		for (NameValuePair nameValuePair : params) {
			str.append(nameValuePair.getName() + "=" + nameValuePair.getValue() + "&");
		}
		str = str.deleteCharAt(str.length() - 1);
		url = url + "?" + str.toString();
		try {
			// FileInputStream fis = new FileInputStream(url);

			URL url2 = new URL(url);
			HttpURLConnection httpConn = (HttpURLConnection) url2.openConnection();
			// 设置参数
			httpConn.setDoOutput(true); // 需要输出
			httpConn.setDoInput(true); // 需要输入
			httpConn.setUseCaches(false); // 不允许缓存
			httpConn.setRequestMethod("POST"); // 设置POST方式连接
			// 设置请求属性
			httpConn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
			// httpConn.setRequestProperty("Content-Type",
			// "multipart/form-data");
			httpConn.setRequestProperty("Connection", "Keep-Alive");// 维持长连接
			httpConn.setRequestProperty("Charset", "UTF-8");
			// 连接,也可以不用明文connect，使用下面的httpConn.getOutputStream()会自动connect
			httpConn.connect();
			// 建立输入流，向指向的URL传入参数
			DataOutputStream dos = new DataOutputStream(httpConn.getOutputStream());
			// part 1
			String part1 = "--" + boundary + Enter + "Content-Type: application/octet-stream" + Enter
					+ "Content-Disposition: form-data; filename=\"1234\"; name=\"file\"" + Enter + Enter;
			// part 2
			String part2 = Enter + "--" + boundary + Enter + "Content-Type: text/plain" + Enter
					+ "Content-Disposition: form-data; name=\"dataFormat\"" + Enter + Enter + "hk" + Enter + "--"
					+ boundary + "--";

			// dos.writeBytes(str.toString());
			byte[] Bytes = new byte[fis.available()];
			fis.read(Bytes);

			dos.writeBytes(part1);
			dos.write(Bytes);
			dos.writeBytes(part2);

			dos.flush();
			dos.close();
			fis.close();

			httpConn.disconnect();

			int resultCode = httpConn.getResponseCode();
			if (HttpURLConnection.HTTP_OK == resultCode) {
				StringBuffer sb = new StringBuffer();
				String readLine = new String();
				BufferedReader responseReader = new BufferedReader(
						new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
				while ((readLine = responseReader.readLine()) != null) {
					sb.append(readLine).append("\n");
				}
				responseReader.close();
				return sb.toString();
			}

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return null;

		// CloseableHttpClient httpclient = HttpClients.createDefault();
		// HttpPost httpPost = new HttpPost(uri);
		// CloseableHttpResponse response = null;
		// try {
		// response = httpclient.execute(httpPost);
		// HttpEntity reponseEntity = response.getEntity();
		// if (reponseEntity != null) {
		// InputStream instream = reponseEntity.getContent();
		// try {
		// BufferedReader in = new BufferedReader(new
		// InputStreamReader(instream, "UTF-8"));
		// StringBuffer buffer = new StringBuffer();
		// String line = "";
		// while ((line = in.readLine()) != null) {
		// buffer.append(line);
		// }
		// return buffer.toString();
		// } finally {
		// instream.close();
		// }
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// return null;
	}
	
	public static String doPost(String url, List<NameValuePair> params, InputStream is) {
		// URI uri = null;
		// try {
		// if (params != null)
		// uri = new URIBuilder(url).setParameters(params).build();
		// else
		// uri = new URIBuilder(url).build();
		// } catch (URISyntaxException e1) {
		// e1.printStackTrace();
		// }
		
		String boundary = "Boundary-b1ed-4060-99b9-fca7ff59c113"; // Could be
		// any
		// string
		String Enter = "\r\n";
		StringBuffer str = new StringBuffer();
		for (NameValuePair nameValuePair : params) {
			str.append(nameValuePair.getName() + "=" + nameValuePair.getValue() + "&");
		}
		str = str.deleteCharAt(str.length() - 1);
		url = url + "?" + str.toString();
		try {
			// FileInputStream fis = new FileInputStream(url);
			
			URL url2 = new URL(url);
			HttpURLConnection httpConn = (HttpURLConnection) url2.openConnection();
			// 设置参数
			httpConn.setDoOutput(true); // 需要输出
			httpConn.setDoInput(true); // 需要输入
			httpConn.setUseCaches(false); // 不允许缓存
			httpConn.setRequestMethod("POST"); // 设置POST方式连接
			// 设置请求属性
			httpConn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
			// httpConn.setRequestProperty("Content-Type",
			// "multipart/form-data");
			httpConn.setRequestProperty("Connection", "Keep-Alive");// 维持长连接
			httpConn.setRequestProperty("Charset", "UTF-8");
			// 连接,也可以不用明文connect，使用下面的httpConn.getOutputStream()会自动connect
			httpConn.connect();
			// 建立输入流，向指向的URL传入参数
			DataOutputStream dos = new DataOutputStream(httpConn.getOutputStream());
			// part 1
			String part1 = "--" + boundary + Enter + "Content-Type: application/octet-stream" + Enter
					+ "Content-Disposition: form-data; filename=\"1234\"; name=\"file\"" + Enter + Enter;
			// part 2
			String part2 = Enter + "--" + boundary + Enter + "Content-Type: text/plain" + Enter
					+ "Content-Disposition: form-data; name=\"dataFormat\"" + Enter + Enter + "hk" + Enter + "--"
					+ boundary + "--";
			
			// dos.writeBytes(str.toString());
			byte[] Bytes = new byte[is.available()];
			is.read(Bytes);
			
			dos.writeBytes(part1);
			dos.write(Bytes);
			dos.writeBytes(part2);
			
			dos.flush();
			dos.close();
			is.close();
			
			httpConn.disconnect();
			
			int resultCode = httpConn.getResponseCode();
			if (HttpURLConnection.HTTP_OK == resultCode) {
				StringBuffer sb = new StringBuffer();
				String readLine = new String();
				BufferedReader responseReader = new BufferedReader(
						new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
				while ((readLine = responseReader.readLine()) != null) {
					sb.append(readLine).append("\n");
				}
				responseReader.close();
				return sb.toString();
			}
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return null;
		
		// CloseableHttpClient httpclient = HttpClients.createDefault();
		// HttpPost httpPost = new HttpPost(uri);
		// CloseableHttpResponse response = null;
		// try {
		// response = httpclient.execute(httpPost);
		// HttpEntity reponseEntity = response.getEntity();
		// if (reponseEntity != null) {
		// InputStream instream = reponseEntity.getContent();
		// try {
		// BufferedReader in = new BufferedReader(new
		// InputStreamReader(instream, "UTF-8"));
		// StringBuffer buffer = new StringBuffer();
		// String line = "";
		// while ((line = in.readLine()) != null) {
		// buffer.append(line);
		// }
		// return buffer.toString();
		// } finally {
		// instream.close();
		// }
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// return null;
	}
	
	public static String doPost(String url, List<NameValuePair> params, String name, InputStream is) {
		// URI uri = null;
		// try {
		// if (params != null)
		// uri = new URIBuilder(url).setParameters(params).build();
		// else
		// uri = new URIBuilder(url).build();
		// } catch (URISyntaxException e1) {
		// e1.printStackTrace();
		// }
		
		String boundary = "Boundary-b1ed-4060-99b9-fca7ff59c113"; // Could be
		// any
		// string
		String Enter = "\r\n";
		StringBuffer str = new StringBuffer();
		for (NameValuePair nameValuePair : params) {
			str.append(nameValuePair.getName() + "=" + nameValuePair.getValue() + "&");
		}
		str = str.deleteCharAt(str.length() - 1);
		url = url + "?" + str.toString();
		try {
			// FileInputStream fis = new FileInputStream(url);
			
			URL url2 = new URL(url);
			HttpURLConnection httpConn = (HttpURLConnection) url2.openConnection();
			// 设置参数
			httpConn.setDoOutput(true); // 需要输出
			httpConn.setDoInput(true); // 需要输入
			httpConn.setUseCaches(false); // 不允许缓存
			httpConn.setRequestMethod("POST"); // 设置POST方式连接
			// 设置请求属性
			httpConn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
			// httpConn.setRequestProperty("Content-Type",
			// "multipart/form-data");
			httpConn.setRequestProperty("Connection", "Keep-Alive");// 维持长连接
			httpConn.setRequestProperty("Charset", "UTF-8");
			// 连接,也可以不用明文connect，使用下面的httpConn.getOutputStream()会自动connect
			httpConn.connect();
			// 建立输入流，向指向的URL传入参数
			DataOutputStream dos = new DataOutputStream(httpConn.getOutputStream());
			// part 1
			String part1 = "--" + boundary + Enter + "Content-Type: application/octet-stream" + Enter
					+ "Content-Disposition: form-data; filename=\""+name+"\"; name=\"file\"" + Enter + Enter;
			// part 2
			String part2 = Enter + "--" + boundary + Enter + "Content-Type: text/plain" + Enter
					+ "Content-Disposition: form-data; name=\"dataFormat\"" + Enter + Enter + "hk" + Enter + "--"
					+ boundary + "--";
			
			// dos.writeBytes(str.toString());
			byte[] Bytes = new byte[is.available()];
			is.read(Bytes);
			
			dos.writeBytes(part1);
			dos.write(Bytes);
			dos.writeBytes(part2);
			
			dos.flush();
			dos.close();
			is.close();
			
			httpConn.disconnect();
			
			int resultCode = httpConn.getResponseCode();
			if (HttpURLConnection.HTTP_OK == resultCode) {
				StringBuffer sb = new StringBuffer();
				String readLine = new String();
				BufferedReader responseReader = new BufferedReader(
						new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
				while ((readLine = responseReader.readLine()) != null) {
					sb.append(readLine).append("\n");
				}
				responseReader.close();
				return sb.toString();
			}
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return null;
		
		// CloseableHttpClient httpclient = HttpClients.createDefault();
		// HttpPost httpPost = new HttpPost(uri);
		// CloseableHttpResponse response = null;
		// try {
		// response = httpclient.execute(httpPost);
		// HttpEntity reponseEntity = response.getEntity();
		// if (reponseEntity != null) {
		// InputStream instream = reponseEntity.getContent();
		// try {
		// BufferedReader in = new BufferedReader(new
		// InputStreamReader(instream, "UTF-8"));
		// StringBuffer buffer = new StringBuffer();
		// String line = "";
		// while ((line = in.readLine()) != null) {
		// buffer.append(line);
		// }
		// return buffer.toString();
		// } finally {
		// instream.close();
		// }
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// return null;
	}

	/**
	 * 
	 * @author lvwenwen
	 * @dateTime 2016-6-1 上午11:28:32
	 * @description
	 * @param url
	 * @param params
	 * @return
	 */
	public static InputStream forwardingfile(String url, List<NameValuePair> params) {
		URI uri = null;
		try {
			if (params != null)
				uri = new URIBuilder(url).setParameters(params).build();
			else
				uri = new URIBuilder(url).build();
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(uri);
		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httpGet);
			HttpEntity reponseEntity = response.getEntity();
			if (reponseEntity != null) {
				InputStream instream = reponseEntity.getContent();
				return instream;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Boolean requestOk(JsonNode jsonNode) {
		if (jsonNode != null && jsonNode.get("recode") != null) {
			int recode = jsonNode.get("recode").asInt();
			switch (recode) {
			case 0:
				return Boolean.TRUE;
			case 1:
				return Boolean.FALSE;
			default:
				return Boolean.FALSE;
			}
		}
		return Boolean.FALSE;
	}
}

