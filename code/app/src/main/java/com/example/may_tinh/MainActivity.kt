package com.example.may_tinh

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import org.w3c.dom.Text

// ExpressionBuilder là thư viên hộ trộ tính toán

class MainActivity : AppCompatActivity() {
//public class MainActivity extends AppCompatActivity(){
    // static globle variable here please Tommmmm
//    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Numbers
        findViewById<TextView>(R.id.tv_one).setOnClickListener{ appendOnExpresstion("1", true)}
        findViewById<TextView>(R.id.tv_two).setOnClickListener{ appendOnExpresstion("2", true)}
        findViewById<TextView>(R.id.tv_three).setOnClickListener{ appendOnExpresstion("3", true)}
        findViewById<TextView>(R.id.tv_four).setOnClickListener{ appendOnExpresstion("4", true)}
        findViewById<TextView>(R.id.tv_five).setOnClickListener{ appendOnExpresstion("5", true)}
        findViewById<TextView>(R.id.tv_six).setOnClickListener{ appendOnExpresstion("6", true)}
        findViewById<TextView>(R.id.tv_seven).setOnClickListener{ appendOnExpresstion("7", true)}
        findViewById<TextView>(R.id.tv_eight).setOnClickListener{ appendOnExpresstion("8", true)}
        findViewById<TextView>(R.id.tv_nine).setOnClickListener{ appendOnExpresstion("9", true)}
        findViewById<TextView>(R.id.tv_zero).setOnClickListener{ appendOnExpresstion("0", true)}
        findViewById<TextView>(R.id.tv_dot).setOnClickListener{ appendOnExpresstion(".", true)}


        //Operators
        findViewById<TextView>(R.id.tv_plus).setOnClickListener{ appendOnExpresstion("+", false)}
        findViewById<TextView>(R.id.tv_minus).setOnClickListener{ appendOnExpresstion("-", false)}
        findViewById<TextView>(R.id.tv_mul).setOnClickListener{ appendOnExpresstion("*", false)}
        findViewById<TextView>(R.id.tv_divide).setOnClickListener{ appendOnExpresstion("/", false)}
        findViewById<TextView>(R.id.tv_open_quote).setOnClickListener{ appendOnExpresstion("(", false)}
        findViewById<TextView>(R.id.tv_close_quote).setOnClickListener{ appendOnExpresstion(")", false)}



        // nút xoá DE
        val tv_clear = findViewById<TextView>(R.id.tv_clear)


        tv_clear.setOnClickListener {
            tv_expression.text = ""
            tv_result.text = ""
        }
        // nút xoá từng số
        val tv_back = findViewById<ImageView>(R.id.tv_back)

        tv_back.setOnClickListener {
            val string = tv_expression.text.toString()
            if (string.isNotEmpty()) {
                tv_expression.text = string.substring(0, string.length - 1)
            }
            tv_result.text = ""
        }
        // kết quả
        val tv_equals = findViewById<TextView>(R.id.tv_equals)

        tv_equals.setOnClickListener {
            try {
                    // xử lí tính toán
                val expression = ExpressionBuilder(tv_expression.text.toString()).build()
                // hàm tính toán evaluate dựa trên chuỗi string
//                var phep_tinh = "1-1"
//                phep_tinh.evaluate()
                val result = expression.evaluate()
                val longResult = result.toLong()
                // check kỉêu dữ liệu của kết quả để trả lại đúng kỉêu
                if (result == longResult.toDouble()){
                    tv_expression.text = longResult.toString()
                    tv_result.text = longResult.toString()
                }

                else
                    tv_expression.text = result.toString()

            } catch (e: Exception) {
//                Log.d("Exception", " message : " + e.message)
                tv_result.text = e.message
            }
        }

    }
    // trigger từng nút
    fun appendOnExpresstion(string_to_show_expression: String, canClear: Boolean) {
        // nếu có thể xoá
        if (canClear === true) {
//            tv_result.text = ""
            tv_expression.append(string_to_show_expression)
        } else {
//            tv_expression.append(tv_result.text)
            tv_expression.append(string_to_show_expression)
//            tv_result.text = ""
        }
    }
}
