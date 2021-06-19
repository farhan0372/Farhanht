package com.example.ripazitori

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //        frm-1
        val frm_1=findViewById<FrameLayout>(R.id.ac_main_frm_1)
        val edt_name=findViewById<EditText>(R.id.ac_main_edt_name)
        val edt_family=findViewById<EditText>(R.id.ac_main_edt_family)
        val edt_name_father=findViewById<EditText>(R.id.ac_main_edt_name_father)
        val edt_phone=findViewById<EditText>(R.id.ac_main_edt_phone)
        val rgb_Jens=findViewById<RadioGroup>(R.id.ac_main_rgb_Jens)
        val cb_Quran=findViewById<CheckBox>(R.id.ac_main_cb_Quran)
        val cb_Varzesh=findViewById<CheckBox>(R.id.ac_main_cb_Varzesh)
        val cb_Riazi=findViewById<CheckBox>(R.id.ac_main_cb_riazi)
        val cb_honar=findViewById<CheckBox>(R.id.ac_main_cb_Honar)
        val btn_confirm=findViewById<Button>(R.id.ac_main_btn_confirm)

        val sp_1= arrayOf("انتخاب کنید","حساب عادی","حساب برنزه","حساب طلایی")
        val sp_2=findViewById<Spinner>(R.id.ac_main_sp_account)
        val adapter=ArrayAdapter(this,android.R.layout.simple_spinner_item,sp_1)
        sp_2.adapter=adapter


//        frm2
        val frm_2=findViewById<FrameLayout>(R.id.ac_main_frm_2)
        val tv_name=findViewById<TextView>(R.id.ac_main_tv_name)
        val tv_family=findViewById<TextView>(R.id.ac_main_tv_family)
        val tv_name_father=findViewById<TextView>(R.id.ac_main_tv_name_father)
        val tv_phone=findViewById<TextView>(R.id.ac_main_tv_phone)
        val tv_Jens=findViewById<TextView>(R.id.ac_main_tv_Jens)
        val tv_account=findViewById<TextView>(R.id.ac_main_tv_account)
        val tv_alaghe=findViewById<TextView>(R.id.ac_main_tv_alaghe)


        btn_confirm.setOnClickListener {

            if(edt_name.text.toString()=="" || edt_family.text.toString()=="" || edt_name_father.text.toString()=="" || edt_phone.text.toString()==""){
                Toast.makeText(this, "فیلدها خالی میباشد", Toast.LENGTH_SHORT).show()
            }
            else if(!edt_phone.text.toString().startsWith("09")){
                Toast.makeText(this, "از 09 شروع میشود", Toast.LENGTH_SHORT).show()
            }
            else if(edt_phone.text.toString().length!=11){
                Toast.makeText(this, "شماره نامعتبر . شماره 11 رقمی میباشد", Toast.LENGTH_SHORT).show()
            }
            else if(rgb_Jens.checkedRadioButtonId==-1){
                Toast.makeText(this, "جنسیت انتخاب نشده است", Toast.LENGTH_SHORT).show()
            }
            else if(sp_2.selectedItemPosition==0){
                Toast.makeText(this, "حساب کاربری خود را وارد کنید", Toast.LENGTH_SHORT).show()
            }
            else if(!cb_Quran.isChecked && !cb_Varzesh.isChecked && !cb_Riazi.isChecked && !cb_honar.isChecked){
                Toast.makeText(this, "گزینه مورد نطر را انتخاب کنید", Toast.LENGTH_SHORT).show()
            }
            else if(cb_Quran.isChecked && cb_Varzesh.isChecked && cb_Riazi.isChecked && cb_honar.isChecked){
                Toast.makeText(this, "گزینه بیشتر از 2 نمیتواند انتخاب شود", Toast.LENGTH_SHORT).show()
            }
            else if(cb_Quran.isChecked && cb_Varzesh.isChecked && cb_Riazi.isChecked){
                Toast.makeText(this ,"گزینه بیشتر از 2 نمیتواند انتخاب شود", Toast.LENGTH_SHORT).show()
            }
            else if(cb_Quran.isChecked && cb_Varzesh.isChecked && cb_honar.isChecked){
                Toast.makeText(this ,"گزینه بیشتر از 2 نمیتواند انتخاب شود", Toast.LENGTH_SHORT).show()
            }
            else if(cb_Quran.isChecked && cb_Riazi.isChecked && cb_honar.isChecked){
                Toast.makeText(this ,"گزینه بیشتر از 2 نمیتواند انتخاب شود", Toast.LENGTH_SHORT).show()
            }
            else if(cb_Varzesh.isChecked && cb_Riazi.isChecked && cb_honar.isChecked){
                Toast.makeText(this ,"گزینه بیشتر از 2 نمیتواند انتخاب شود", Toast.LENGTH_SHORT).show()
            }

            else{
                frm_1.visibility= View.GONE
                frm_2.visibility=View.VISIBLE

                tv_name.text=edt_name.text.toString()
                tv_family.text=edt_family.text.toString()
                tv_name_father.text=edt_name_father.text.toString()
                tv_phone.text=edt_phone.text.toString()

                val rb=findViewById<RadioButton>(rgb_Jens.checkedRadioButtonId)
                tv_Jens.text=rb.text.toString()

                if(sp_2.selectedItemPosition==1){
                    tv_account.text="نوع اکانت : اکانت عادی"
                }
                if(sp_2.selectedItemPosition==2){
                    tv_account.text="نوع اکانت : اکانت برنزه"
                }
                if(sp_2.selectedItemPosition==3){
                    tv_account.text="نوع اکانت : اکانت طلایی"
                }

                if(cb_Quran.isChecked){
                    tv_alaghe.text=cb_Quran.text.toString()
                }
                if(cb_Varzesh.isChecked){
                    tv_alaghe.text=cb_Varzesh.text.toString()
                }
                if(cb_Riazi.isChecked){
                    tv_alaghe.text=cb_Riazi.text.toString()
                }
                if(cb_honar.isChecked){
                    tv_alaghe.text=cb_honar.text.toString()
                }

                if(cb_Quran.isChecked && cb_Varzesh.isChecked){
                    tv_alaghe.text=cb_Quran.text.toString()+" , "+cb_Varzesh.text.toString()
                }
                if(cb_Quran.isChecked && cb_Riazi.isChecked){
                    tv_alaghe.text=cb_Quran.text.toString()+" , "+cb_Riazi.text.toString()
                }
                if(cb_Quran.isChecked && cb_honar.isChecked){
                    tv_alaghe.text=cb_Quran.text.toString()+" , "+cb_honar.text.toString()
                }
                if(cb_Varzesh.isChecked && cb_Riazi.isChecked){
                    tv_alaghe.text=cb_Varzesh.text.toString()+" , "+cb_Riazi.text.toString()
                }
                if(cb_Varzesh.isChecked && cb_honar.isChecked){
                    tv_alaghe.text=cb_Varzesh.text.toString()+" , "+cb_honar.text.toString()
                }
                if(cb_Riazi.isChecked && cb_honar.isChecked){
                    tv_alaghe.text=cb_Riazi.text.toString()+" , "+cb_honar.text.toString()
                }

            }


        }
    }
}