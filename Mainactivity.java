public class MainActivity extends AppCompatActivity {

    private EditText searchEditText;
    private Button searchButton;
  
    private TextView meaningTextView;

    private Map<String, String> dictionaryData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      searchEditText = findViewById(R.id.searchEditText);
        searchButton = findViewById(R.id.searchButton);
    meaningTextView = findViewById(R.id.meaningTextView);
        dictionaryData = new HashMap<>();
dictionaryData.put("apple", "A fruit that grows on trees.");
        dictionaryData.put("banana", "A long curved fruit that grows in bunches.");
        searchButton.setOnClickListener(v -> {
            String word = searchEditText.getText().toString().toLowerCase();
            String meaning = dictionaryData.get(word);
   if (meaning != null) {
                meaningTextView.setText(meaning);
            } else {
                meaningTextView.setText("Word not found in the dictionary.");
            }
        });
    }
}
