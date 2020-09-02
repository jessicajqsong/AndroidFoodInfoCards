package com.jessicasjq.foodinfocardstest

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.mylayout.view.*

class MainActivity : AppCompatActivity() {
    var adapter : FoodAdapter? = null
    var foodList = ArrayList<Food>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        foodList.add(Food("Coffee", "Coffee is a brewed drink prepared from roasted coffee beans, the seeds of berries from certain Coffea species. When coffee berries turn from green to bright red in color – indicating ripeness – they are picked, processed, and dried. Dried coffee seeds (referred to as \"beans\") are roasted to varying degrees, depending on the desired flavor. Roasted beans are ground and then brewed with near-boiling water to produce the beverage known as coffee. (Wikipedia)", R.drawable.coffee_pot))
        foodList.add(Food("Espresso", "Espresso is a coffee-making method of Italian origin, in which a small amount of nearly boiling water is forced under pressure (expressed) through finely-ground coffee beans. Espresso coffee can be made with a wide variety of coffee beans and roast levels. Espresso is generally thicker than coffee brewed by other methods, has a higher concentration of suspended and dissolved solids, and has crema on top (a foam with a creamy consistency). As a result of the pressurized brewing process, the flavors and chemicals in a typical cup of espresso are very concentrated. (Wikipedia)", R.drawable.espresso))
        foodList.add(Food("French Fries", "French fries are served hot, either soft or crispy, and are generally eaten as part of lunch or dinner or by themselves as a snack, and they commonly appear on the menus of diners, fast food restaurants, pubs, and bars. They are usually salted and, depending on the country, may be served with ketchup, vinegar, mayonnaise, tomato sauce, or other local specialties. Fries can be topped more heavily, as in the dishes of poutine or chili cheese fries. Chips can be made from sweet potatoes instead of potatoes. A baked variant, oven chips, uses less oil or no oil. (Wikipedia)", R.drawable.french_fries))
        foodList.add(Food("Honey", "Honey is a sweet, viscous food substance made by honey bees and some related insects. Bees produce honey from the sugary secretions of plants (floral nectar) or from secretions of other insects (such as honeydew), by regurgitation, enzymatic activity, and water evaporation. Bees store honey in wax structures called honeycombs. The variety of honey produced by honey bees (the genus Apis) is the best-known, due to its worldwide commercial production and human consumption. Honey is collected from wild bee colonies, or from hives of domesticated bees, a practice known as beekeeping or apiculture. (Wikipedia)", R.drawable.honey))
        foodList.add(Food("Strawberry Ice Cream", "Ice cream is a sweetened frozen food typically eaten as a snack or dessert. It may be made from dairy milk or cream and is flavoured with a sweetener, either sugar or an alternative, and any spice, such as cocoa or vanilla. Colourings are usually added, in addition to stabilizers. (Wikipedia)", R.drawable.strawberry_ice_cream))
        foodList.add(Food("Sugar Cubes", "Sugar, shaped in cubes usually measuring about ~4 grams each, often used for coffee or tea. (Wikipedia)", R.drawable.sugar_cubes))

        adapter = FoodAdapter(this, foodList)
        gridview.adapter = adapter
    }

    class FoodAdapter : BaseAdapter{
        var foodList = ArrayList<Food>()
        var context : Context? = null

        constructor(context: Context?, foodList: ArrayList<Food>) : super() {
            this.foodList = foodList
            this.context = context
        }

        override fun getCount(): Int {
            return foodList.size
        }

        override fun getItem(p0: Int): Any {
            return p0
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var food = this.foodList[p0]
            var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodview = inflater.inflate(R.layout.mylayout, null)
            foodview.imageView.setImageResource(food.image!!)
            foodview.textView.text = food.name!!

            foodview.imageView.setOnClickListener{
                var intent = Intent(context, FoodDetailsActivity::class.java)
                intent.putExtra("name", food.name!!)
                intent.putExtra("description", food.description!!)
                intent.putExtra("image", food.image!!)
                context!!.startActivity(intent)
            }
            return foodview
        }
    }
}

