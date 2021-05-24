package com.example.myteamproject3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.myteamproject3.databinding.ActivityMainBinding
import java.text.DecimalFormat


open class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val url = "http://api.openweathermap.org/data/2.5/weather";
    val appid = "b724ce4365af9091165c61e07361fb8e"
    val df = DecimalFormat("#.##")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.navigationView.itemIconTintList = null
        setContentView(binding.root)


        init()
    }

    private fun init() {
        val intent = Intent(this, SettingActivity::class.java)
        binding.apply {
            imageMenu.setOnClickListener {
                drawerLayout.openDrawer(GravityCompat.START)
            }
            settingBtn.setOnClickListener {
                startActivity(intent)
            }
        }
    }

//    private open fun CurrentCall() {
//        val url =
//            "http://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}"
//        val request: StringRequest =
//            object : StringRequest(Request.Method.GET, url, object : Listener<String?>() {
//                @SuppressLint("SetTextI18n")
//                fun onResponse(response: String?) {
//                    try {
//
//                        //api로 받은 파일 jsonobject로 새로운 객체 선언
//                        val jsonObject = JSONObject(response)
//
//
//                        //도시 키값 받기
//                        val city = jsonObject.getString("name")
//                        cityView.setText(city)
//
//
//                        //날씨 키값 받기
//                        val weatherJson = jsonObject.getJSONArray("weather")
//                        val weatherObj = weatherJson.getJSONObject(0)
//                        val weather = weatherObj.getString("description")
//                        weatherView.setText(weather)
//
//
//                        //기온 키값 받기
//                        val tempK = JSONObject(jsonObject.getString("main"))
//
//                        //기온 받고 켈빈 온도를 섭씨 온도로 변경
//                        val tempDo =
//                            Math.round((tempK.getDouble("temp") - 273.15) * 100) / 100.0
//                        tempView.setText("$tempDo°C")
//                    } catch (e: JSONException) {
//                        e.printStackTrace()
//                    }
//                }
//            }, object : ErrorListener() {
//                fun onErrorResponse(error: VolleyError?) {}
//            }) {
//                @Throws(AuthFailureError::class)
//                override fun getParams(): Map<String, String> {
//                    return HashMap()
//                }
//            }
//        request.setShouldCache(false)
//        requestQueue.add(request)
//    }
}

